/*
 * Copyright 2017-2019, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.testsuite.oauth.mockoauth;

import io.strimzi.kafka.oauth.common.BearerTokenWithPayload;
import io.strimzi.kafka.oauth.common.Config;
import io.strimzi.kafka.oauth.common.ConfigException;
import io.strimzi.kafka.oauth.common.OAuthAuthenticator;
import io.strimzi.kafka.oauth.common.PrincipalExtractor;
import io.strimzi.kafka.oauth.common.SSLUtil;
import io.strimzi.kafka.oauth.common.TokenInfo;
import io.strimzi.kafka.oauth.server.JaasServerOauthValidatorCallbackHandler;
import io.strimzi.kafka.oauth.server.OAuthKafkaPrincipal;
import io.strimzi.kafka.oauth.server.OAuthKafkaPrincipalBuilder;
import io.strimzi.kafka.oauth.server.ServerConfig;
import io.strimzi.kafka.oauth.server.TestTokenFactory;
import io.strimzi.kafka.oauth.server.authorizer.AuthzConfig;
import io.strimzi.kafka.oauth.server.authorizer.KeycloakAuthorizer;
import io.strimzi.kafka.oauth.server.authorizer.KeycloakRBACAuthorizer;
import io.strimzi.kafka.oauth.server.authorizer.TestAuthzUtil;
import io.strimzi.testsuite.oauth.common.TestUtil;
import org.apache.kafka.common.acl.AclOperation;
import org.apache.kafka.common.resource.PatternType;
import org.apache.kafka.common.resource.ResourcePattern;
import org.apache.kafka.common.resource.ResourceType;
import org.apache.kafka.common.security.auth.AuthenticateCallbackHandler;
import org.apache.kafka.common.security.auth.KafkaPrincipal;
import org.apache.kafka.common.security.auth.SaslAuthenticationContext;
import org.apache.kafka.common.security.auth.SecurityProtocol;
import org.apache.kafka.common.security.oauthbearer.OAuthBearerToken;
import org.apache.kafka.common.security.oauthbearer.OAuthBearerValidatorCallback;
import org.apache.kafka.common.security.oauthbearer.internals.OAuthBearerSaslServer;
import org.apache.kafka.server.authorizer.Action;
import org.apache.kafka.server.authorizer.AuthorizableRequestContext;
import org.apache.kafka.server.authorizer.AuthorizationResult;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.AppConfigurationEntry;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static io.strimzi.testsuite.oauth.common.TestUtil.checkLogForRegex;
import static io.strimzi.testsuite.oauth.mockoauth.Common.addGrantsForToken;
import static io.strimzi.testsuite.oauth.mockoauth.Common.changeAuthServerMode;
import static io.strimzi.testsuite.oauth.mockoauth.Common.checkLog;
import static io.strimzi.testsuite.oauth.mockoauth.Common.createOAuthClient;
import static io.strimzi.testsuite.oauth.mockoauth.Common.createOAuthUser;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KeycloakAuthorizerTest {

    private static final Logger LOG = LoggerFactory.getLogger(KeycloakAuthorizerTest.class);

    static final int LOOP_PAUSE_MS = 1000;
    static final int TIMEOUT_SECONDS = 30;

    static final String CLIENT_CLI = "kafka-cli";

    static final String USER_ALICE = "alice";
    static final String USER_ALICE_PASS = "alice-password";

    final static String TRUSTSTORE_PATH = "../docker/target/kafka/certs/ca-truststore.p12";
    final static String TRUSTSTORE_PASS = "changeit";

    final static String TOKEN_ENDPOINT = "https://mockoauth:8090/token";
    final static String FAILING_TOKEN_ENDPOINT = "https://mockoauth:8090/failing_token";

    final static String GRANTS_ENDPOINT = "https://mockoauth:8090/grants";

    final static String JWKS_ENDPOINT = "https://mockoauth:8090/jwks";
    final static String VALID_ISSUER_URI = "https://mockoauth:8090";


    final static String CLIENT_SRV = "kafka";
    final static String CLIENT_SRV_SECRET = "kafka-secret";

    public static void staticInit() throws IOException {
        // create a client for resource server
        createOAuthClient(CLIENT_SRV, CLIENT_SRV_SECRET);

        // create a client for user's client agent
        createOAuthClient(CLIENT_CLI, "");

        // create a user alice
        createOAuthUser(USER_ALICE, USER_ALICE_PASS);
    }

    public void doTests() throws Exception {
        doConfigTests();
        doMalformedGrantsTests();
        doGrantsSemanticEqualsTest();
        doHttpRetriesTest();
        doConcurrentGrantsRefreshTest();
        doGrantsGCTests();
        doGrants403Test();
        doGrants401Test();
        doSingletonTest();
    }

    void doGrants401Test() throws IOException, InterruptedException, TimeoutException {
        logStart("KeycloakAuthorizerTest :: Grants 401 (invalid token) Test");

        changeAuthServerMode("token", "MODE_200");

        LogLineReader logReader = new LogLineReader(Common.LOG_PATH);
        logReader.readNext();

        List<String> lines;
        HashMap<String, String> props = configureAuthorizer();
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_TOKEN_ENDPOINT_URI, "https://mockoauth:8090/grants");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_REFRESH_PERIOD_SECONDS, "4");

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(props);

            // authentication
            TokenInfo tokenInfo = login(TOKEN_ENDPOINT, USER_ALICE, USER_ALICE_PASS, 1);

            //   simulate an authenticated session
            changeAuthServerMode("jwks", "MODE_200");

            //     configure the authentication handler
            AuthenticateCallbackHandler authHandler = configureJwtSignatureValidator();

            LOG.info("Authenticate (validate) as alice");
            OAuthKafkaPrincipal principal = authenticate(authHandler, tokenInfo);


            // authorization
            AuthorizableRequestContext ctx = newAuthorizableRequestContext(principal);

            List<Action> actions = new ArrayList<>();
            actions.add(new Action(
                    AclOperation.CREATE,
                    new ResourcePattern(ResourceType.TOPIC, "my-topic", PatternType.LITERAL),
                    1, true, true));

            List<AuthorizationResult> result = authorizer.authorize(ctx, actions);
            Assert.assertNotNull("Authorizer has to return non-null", result);
            Assert.assertEquals("Authorizer has to return as many results as it received inputs", result.size(), actions.size());
            Assert.assertEquals("Authorizer should return ALLOWED", AuthorizationResult.ALLOWED, result.get(0));

            lines = logReader.readNext();
            Assert.assertTrue("Saving non-null grants", checkLogForRegex(lines, "Saving non-null grants"));

            // Switch grants endpoint to 401 mode
            changeAuthServerMode("grants", "MODE_401");

            LOG.info("Waiting for: Done refreshing"); // Make sure to not repeat the below condition in the string here
            lines = logReader.waitFor("Done refreshing grants");
            Assert.assertTrue("Failed to fetch", checkLogForRegex(lines, "Failed to fetch grants .* status 401"));
            Assert.assertTrue("Removed user from grants cache", checkLogForRegex(lines, "Removed user from grants cache: alice"));
            Assert.assertTrue("Removed invalid session", checkLogForRegex(lines, "Removed invalid session from sessions map \\(userId: alice"));

        } finally {
            changeAuthServerMode("grants", "MODE_200");
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    void doGrants403Test() throws IOException {
        logStart("KeycloakAuthorizerTest :: Grants 403 (no policies for user) Test");

        // Switch grants endpoint to 403 mode
        changeAuthServerMode("grants", "MODE_403");

        LogLineReader logReader = new LogLineReader(Common.LOG_PATH);
        logReader.readNext();

        List<String> lines;
        HashMap<String, String> props = configureAuthorizer();
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_TOKEN_ENDPOINT_URI, "https://mockoauth:8090/grants");

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(props);

            TokenInfo tokenInfo = login(FAILING_TOKEN_ENDPOINT, USER_ALICE, USER_ALICE_PASS, 1);
            KafkaPrincipal principal = new OAuthKafkaPrincipal(KafkaPrincipal.USER_TYPE, USER_ALICE, new Common.MockBearerTokenWithPayload(tokenInfo));
            AuthorizableRequestContext ctx = newAuthorizableRequestContext(principal);

            List<Action> actions = new ArrayList<>();
            actions.add(new Action(
                    AclOperation.CREATE,
                    new ResourcePattern(ResourceType.TOPIC, "my-topic", PatternType.LITERAL),
                    1, true, true));

            List<AuthorizationResult> result = authorizer.authorize(ctx, actions);
            Assert.assertNotNull("Authorizer has to return non-null", result);
            Assert.assertEquals("Authorizer has to return as many results as it received inputs", result.size(), actions.size());
            Assert.assertEquals("Authorizer should return DENIED", AuthorizationResult.DENIED, result.get(0));

            lines = logReader.readNext();

            Assert.assertTrue("Saving non-null grants", checkLogForRegex(lines, "Saving non-null grants"));
            Assert.assertTrue("grants for user: {}", checkLogForRegex(lines, "grants for .*: \\{\\}"));

        } finally {
            changeAuthServerMode("grants", "MODE_200");
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    void doHttpRetriesTest() throws IOException {
        logStart("KeycloakAuthorizerTest :: Grants HTTP Retries Tests");

        changeAuthServerMode("token", "MODE_200");
        changeAuthServerMode("failing_token", "MODE_400");

        HashMap<String, String> props = configureAuthorizer();
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_TOKEN_ENDPOINT_URI, "https://mockoauth:8090/failing_grants");

        try (KeycloakRBACAuthorizer authorizer = new KeycloakRBACAuthorizer()) {
            authorizer.configure(props);

            try {
                login(FAILING_TOKEN_ENDPOINT, USER_ALICE, USER_ALICE_PASS, 0);

                Assert.fail("Should have failed while logging in with password");

            } catch (Exception expected) {
                login(FAILING_TOKEN_ENDPOINT, USER_ALICE, USER_ALICE_PASS, 0);
            }

            // Now try again
            TokenInfo tokenInfo = login(FAILING_TOKEN_ENDPOINT, USER_ALICE, USER_ALICE_PASS, 1);
            KafkaPrincipal principal = new OAuthKafkaPrincipal(KafkaPrincipal.USER_TYPE, USER_ALICE, new Common.MockBearerTokenWithPayload(tokenInfo));
            AuthorizableRequestContext ctx = newAuthorizableRequestContext(principal);

            List<Action> actions = new ArrayList<>();
            actions.add(new Action(
                    AclOperation.CREATE,
                    new ResourcePattern(ResourceType.TOPIC, "my-topic", PatternType.LITERAL),
                    1, true, true));

            List<AuthorizationResult> result = authorizer.authorize(ctx, actions);
            Assert.assertNotNull("Authorizer has to return non-null", result);
            Assert.assertEquals("Authorizer has to return as many results as it received inputs", result.size(), actions.size());
            Assert.assertEquals("Authorizer should return ALLOWED", AuthorizationResult.ALLOWED, result.get(0));
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    /**
     * This test makes sure the concurrent threads needing grants for the same user that is not yet available in grants cache
     * result in a single request to the Keycloak server, with second thread waiting for result and reusing it.
     *
     * @throws IOException If an exception occurs during I/O operation
     * @throws ExecutionException If an exception occurs during job execution
     * @throws InterruptedException If test is interrupted
     */
    void doConcurrentGrantsRefreshTest() throws IOException, ExecutionException, InterruptedException {
        logStart("KeycloakAuthorizerTest :: Concurrent Grants Refresh Tests");

        // create a test user 'user1'
        String userOne = "user1";
        String userOnePass = "user1-password";
        createOAuthUser(userOne, userOnePass);

        changeAuthServerMode("token", "MODE_200");
        changeAuthServerMode("failing_token", "MODE_400");

        // grants endpoint has to be configured to respond with a 1s delay
        changeAuthServerMode("grants", "MODE_200_DELAYED");

        // one test uses KeycloakAuthorizer not configured with 'strimzi.authorization.reuse.grants'
        HashMap<String, String> props = configureAuthorizer();
        runConcurrentFetchGrantsTest(props, true, userOne, userOnePass);

        // another test uses KeycloakAuthorizer configured with it set to 'false'
        props.put("strimzi.authorization.reuse.grants", "false");
        runConcurrentFetchGrantsTest(props, false, userOne, userOnePass);
    }

    private void runConcurrentFetchGrantsTest(HashMap<String, String> props, boolean withReuse, String user, String userPass) throws IOException, ExecutionException, InterruptedException {

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(props);

            LogLineReader logReader = new LogLineReader(Common.LOG_PATH);
            List<String> lines = logReader.readNext();

            if (withReuse) {
                Assert.assertTrue("reuseGrants should be true", checkLogForRegex(lines, "reuseGrants: true"));
            } else {
                Assert.assertTrue("reuseGrants should default to false", checkLogForRegex(lines, "reuseGrants: false"));
            }

            TokenInfo tokenInfo = login(FAILING_TOKEN_ENDPOINT, user, userPass, 1);
            OAuthKafkaPrincipal principal = new OAuthKafkaPrincipal(KafkaPrincipal.USER_TYPE, user, TestTokenFactory.newTokenForUser(tokenInfo));

            addGrantsForToken(tokenInfo.token(), "[{\"scopes\":[\"Delete\",\"Write\",\"Describe\",\"Read\",\"Alter\",\"Create\",\"DescribeConfigs\",\"AlterConfigs\"],\"rsid\":\"ca6f195f-dbdc-48b7-a953-8e441d17f7fa\",\"rsname\":\"Topic:my-topic*\"}," +
                    "{\"scopes\":[\"IdempotentWrite\"],\"rsid\":\"73af36e6-5796-43e7-8129-b57fe0bac7a1\",\"rsname\":\"Cluster:*\"}," +
                    "{\"scopes\":[\"Describe\",\"Read\"],\"rsid\":\"141c56e8-1a85-40f3-b38a-f490bad76913\",\"rsname\":\"Group:*\"}]");

            AuthorizableRequestContext ctx = newAuthorizableRequestContext(principal);


            ExecutorService executorService = Executors.newFixedThreadPool(2);

            try {
                Assert.assertNull("payload should not be set yet: " + principal.getJwt().getPayload(), principal.getJwt().getPayload());

                // In two parallel threads invoke authorize() passing packaged principal
                Future<List<AuthorizationResult>> future = submitAuthorizationCall(authorizer, ctx, executorService, "my-topic");
                Future<List<AuthorizationResult>> future2 = submitAuthorizationCall(authorizer, ctx, executorService, "my-topic-2");

                List<AuthorizationResult> result = future.get();
                List<AuthorizationResult> result2 = future2.get();

                // Check log output for signs of semaphore doing its job
                // and only fetching the grants once, then reusing the fetched grants by the other thread
                // It's the same whether reuseGrants is true or false - because concurrent requests are perceived by user to occur at the same time
                lines = logReader.readNext();

                Assert.assertEquals("One thread fetches grants", 1, TestUtil.countLogForRegex(lines, "Fetching grants from Keycloak for user user1"));
                Assert.assertEquals("One thread waits", 1, TestUtil.countLogForRegex(lines, "Waiting on another thread to get grants"));
                Assert.assertEquals("One grants fetch", 1, TestUtil.countLogForRegex(lines, "Response body for POST https://mockoauth:8090/grants"));

                // Check the authorization result
                Assert.assertEquals("One result for my-topic action", 1, result.size());
                Assert.assertEquals("One result for my-topic-2 action", 1, result2.size());
                Assert.assertEquals("my-topic ALLOWED", AuthorizationResult.ALLOWED, result.get(0));
                Assert.assertEquals("my-topic-2 ALLOWED", AuthorizationResult.ALLOWED, result.get(0));

                if (!withReuse) {
                    // Check that the BearerTokenWithJsonPayload has a payload
                    // That only gets set in no-reuse regime in order to be able to determine if grants were refreshed for the session
                    Assert.assertNotNull("payload should be set now: " + principal.getJwt().getPayload(), principal.getJwt().getPayload());
                }


                // Perform another authorization - grants should be retrieved directly from grants cache,
                // even if reuseGrants is false, because it's not a new session anymore
                future = submitAuthorizationCall(authorizer, ctx, executorService, "x-topic-1");
                result = future.get();

                // check log from last checkpoint on
                lines = logReader.readNext();

                Assert.assertEquals("No grants fetch", 0, TestUtil.countLogForRegex(lines, "Response body for POST https://mockoauth:8090/grants"));

                // Check the authorization result
                Assert.assertEquals("One result for x-topic-1 action", 1, result.size());
                Assert.assertEquals("x-topic-1 DENIED", AuthorizationResult.DENIED, result.get(0));

                // Create a new Principal object for the same user
                // Perform another authorization - grants should be fetched if reuseGrants is false
                principal = new OAuthKafkaPrincipal(KafkaPrincipal.USER_TYPE, user, TestTokenFactory.newTokenForUser(tokenInfo));
                ctx = newAuthorizableRequestContext(principal);

                future = submitAuthorizationCall(authorizer, ctx, executorService, "x-topic-2");
                result = future.get();

                lines = logReader.readNext();
                if (!withReuse) {
                    // Check that grants have been fetched
                    Assert.assertEquals("Grants fetched", 1, TestUtil.countLogForRegex(lines, "Response body for POST https://mockoauth:8090/grants"));
                } else {
                    // Check that grants have not been fetched again
                    Assert.assertEquals("Grants not fetched", 0, TestUtil.countLogForRegex(lines, "Response body for POST https://mockoauth:8090/grants"));
                }

                // Check the authorization result
                Assert.assertEquals("One result for x-topic-2 action", 1, result.size());
                Assert.assertEquals("x-topic-2 DENIED", AuthorizationResult.DENIED, result.get(0));
            } finally {
                executorService.shutdown();
            }
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    void doConfigTests() throws IOException {
        logStart("KeycloakAuthorizerTest :: Config Tests");

        HashMap<String, String> config = new HashMap<>();

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            try {
                authorizer.configure(config);
                Assert.fail("Should have failed");
            } catch (ConfigException e) {
                Assert.assertTrue("'principal.builder.class' is missing", e.getMessage().contains("requires io.strimzi.kafka.oauth.server.OAuthKafkaPrincipalBuilder as 'principal.builder.class'"));
            }
        }
        config.put("principal.builder.class", "io.strimzi.kafka.oauth.server.OAuthKafkaPrincipalBuilder");

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            try {
                authorizer.configure(config);
                Assert.fail("Should have failed");
            } catch (ConfigException e) {
                Assert.assertTrue("'strimzi.authorization.token.endpoint.uri' is missing", e.getMessage().contains("Token Endpoint ('strimzi.authorization.token.endpoint.uri') not set"));
            }
        }
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_TOKEN_ENDPOINT_URI, GRANTS_ENDPOINT);

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            try {
                authorizer.configure(config);
                Assert.fail("Should have failed");
            } catch (ConfigException e) {
                Assert.assertTrue("'strimzi.authorization.client.id' is missing", e.getMessage().contains("client id ('strimzi.authorization.client.id') not set"));
            }
        }
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_CLIENT_ID, "kafka");

        LogLineReader logReader = new LogLineReader(Common.LOG_PATH);

        // Position to the end of the existing log file
        logReader.readNext();

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(config);
        }

        // Check the defaults
        checkLog(logReader, "tokenEndpointUri", "https://mockoauth:8090/grants",
            "clientId", "kafka",
            "sslSocketFactory", "null",
            "hostnameVerifier", "null",
            "clusterName", "kafka-cluster",
            "delegateToKafkaACL", "false",
            "superUsers", "\\[\\]",
            "grantsRefreshPeriodSeconds", "60",
            "grantsRefreshPoolSize", "5",
            "grantsMaxIdleTimeSeconds", "300",
            "httpRetries", "0",
            "reuseGrants", "true",
            "connectTimeoutSeconds", "60",
            "readTimeoutSeconds", "60",
            "enableMetrics", "false",
            "gcPeriodSeconds", "300",
            "includeAcceptHeader", "true"
        );


        // Custom config
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_KAFKA_CLUSTER_NAME, "cluster1");
        config.put("super.users", "User:admin;User:service-account-kafka");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_REFRESH_PERIOD_SECONDS, "180");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_REFRESH_POOL_SIZE, "3");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_MAX_IDLE_TIME_SECONDS, "30");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_HTTP_RETRIES, "2");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_REUSE_GRANTS, "false");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_CONNECT_TIMEOUT_SECONDS, "15");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_READ_TIMEOUT_SECONDS, "15");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_ENABLE_METRICS, "true");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_GC_PERIOD_SECONDS, "60");
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_INCLUDE_ACCEPT_HEADER, "false");

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            try {
                authorizer.configure(config);
                Assert.fail("Should have failed");
            } catch (ConfigException e) {
                Assert.assertEquals("Only one instance per JVM", "Only one authorizer configuration per JVM is supported", e.getMessage());
            }
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(config);
        }

        checkLog(logReader, "clusterName", "cluster1",
                "superUsers", "\\['User:admin', 'User:service-account-kafka'\\]",
                "grantsRefreshPeriodSeconds", "180",
                "grantsRefreshPoolSize", "3",
                "grantsMaxIdleTimeSeconds", "30",
                "httpRetries", "2",
                "reuseGrants", "false",
                "connectTimeoutSeconds", "15",
                "readTimeoutSeconds", "15",
                "enableMetrics", "true",
                "gcPeriodSeconds", "60",
                "includeAcceptHeader", "false"
        );


        // test OAUTH_INCLUDE_ACCEPT_HEADER fallback
        config.remove(AuthzConfig.STRIMZI_AUTHORIZATION_INCLUDE_ACCEPT_HEADER);
        System.setProperty(Config.OAUTH_INCLUDE_ACCEPT_HEADER, "false");

        TestAuthzUtil.clearKeycloakAuthorizerService();
        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(config);
        }

        checkLog(logReader, "clusterName", "cluster1",
                "includeAcceptHeader", "false"
        );

        System.clearProperty(Config.OAUTH_INCLUDE_ACCEPT_HEADER);


        // test gcPeriodSeconds set to 0
        config.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_GC_PERIOD_SECONDS, "0");

        TestAuthzUtil.clearKeycloakAuthorizerService();
        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(config);
        }

        checkLog(logReader,
                "'strimzi.authorization.grants.gc.period.seconds' set to invalid value", "0, using the default value: 300 seconds",
                "gcPeriodSeconds", "300");

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    void doGrantsGCTests() throws Exception {
        logStart("KeycloakAuthorizerTest :: Grants Garbage Collection Tests");

        // Hold on to the created principals to prevent JVM gc() clearing the sessions
        List<OAuthKafkaPrincipal> principals = new LinkedList<>();

        // make sure the token endpoint works fine
        changeAuthServerMode("token", "MODE_200");

        // Make sure grants endpoint is set to normal mode 200
        changeAuthServerMode("grants", "MODE_200");

        String userOne = "gcUser1";
        String userOnePass = "gcUser1-password";
        createOAuthUser(userOne, userOnePass);

        // Set gcPeriodSeconds to 3 seconds
        HashMap<String, String> props = configureAuthorizer();
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_REFRESH_PERIOD_SECONDS, "5");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_GC_PERIOD_SECONDS, "3");

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(props);

            // Perform authentications and authorizations with different access tokens for the same user
            // That will populate the grantsCache map with a single entry and update already existing entry with the latest access token

            // authentication
            TokenInfo tokenInfo = login(TOKEN_ENDPOINT, userOne, userOnePass, 0);

            //   simulate an authenticated session
            changeAuthServerMode("jwks", "MODE_200");

            //     configure the authentication handler
            AuthenticateCallbackHandler authHandler = configureJwtSignatureValidator();


            // check the logs for updated access token
            LogLineReader logReader = new LogLineReader(Common.LOG_PATH);

            // wait for cgGrants run on 0 users
            LOG.info("Waiting for: active users count: 0"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Grants gc: active users count: 0");

            LOG.info("Authenticate (validate) as gcUser1");
            OAuthKafkaPrincipal principal = authenticate(authHandler, tokenInfo);
            principals.add(principal);

            // authorization

            AuthorizableRequestContext authzContext = newAuthorizableRequestContext(principal);

            List<Action> actions = new ArrayList<>();
            actions.add(new Action(
                    AclOperation.CREATE,
                    new ResourcePattern(ResourceType.TOPIC, "my-topic", PatternType.LITERAL),
                    1, true, true));

            //   perform authorization for the session
            LOG.info("Call authorize() as gcUser1");
            List<AuthorizationResult> result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: ALLOWED", AuthorizationResult.ALLOWED, result.get(0));

            // check the logs for updated access token
            List<String> lines = logReader.readNext();
            Assert.assertEquals("Fetch grants", 1, TestUtil.countLogForRegex(lines, "Fetching grants from Keycloak for user gcUser1"));


            String userTwo = "gcUser2";
            String userTwoPass = "gcUser2-password";
            createOAuthUser(userTwo, userTwoPass, 8);

            // Create a short-lived access token for a new user, that only has a 5 seconds lifetime
            // This allows us to test if after 5 seconds the triggered gc job cleans the cache, due to the expired token
            tokenInfo = login(TOKEN_ENDPOINT, userTwo, userTwoPass, 0);

            LOG.info("Authenticate (validate) gcUser2");
            principal = authenticate(authHandler, tokenInfo);
            principals.add(principal);

            LOG.info("Waiting for: active users count: 2, grantsCache size before: 1, grantsCache size after: 1"); // Make sure to not repeat the below condition in the string here
            // wait for cgGrants run on 2 users
            logReader.waitFor("Grants gc: active users count: 2, grantsCache size before: 1, grantsCache size after: 1");


            authzContext = newAuthorizableRequestContext(principal);

            LOG.info("Call authorize() as gcUser2");
            result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: ALLOWED", AuthorizationResult.ALLOWED, result.get(0));

            // wait for cgGrants run on 2 users and two grants cache entries
            LOG.info("Waiting for: active users count: 2, grantsCache size before: 2, grantsCache size after: 2"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Grants gc: active users count: 2, grantsCache size before: 2, grantsCache size after: 2");


            // now wait for token to expire for gcUser2
            LOG.info("Waiting for: active users count: 1, grantsCache size before: 2, grantsCache size after: 1"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Grants gc: active users count: 1, grantsCache size before: 2, grantsCache size after: 1");


            // authorization should now fail since the token has expired
            LOG.info("Authorize another action for gcUser2");
            result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: DENIED", AuthorizationResult.DENIED, result.get(0));
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    private OAuthKafkaPrincipal authenticate(AuthenticateCallbackHandler authHandler, TokenInfo tokenInfo) throws IOException {

        // authenticate with the raw access token, get BearerTokenWithPayload that represents the session
        BearerTokenWithPayload tokenWithPayload = null;
        try {
            tokenWithPayload = (BearerTokenWithPayload) authenticate(authHandler, tokenInfo.token());
        } catch (UnsupportedCallbackException e) {
            Assert.fail("Test error - should never happen: " + e);
        }

        // mock up the authentication workflow part that creates the OAuthKafkaPrincipal
        OAuthKafkaPrincipalBuilder principalBuilder = new OAuthKafkaPrincipalBuilder();
        principalBuilder.configure(new HashMap<>());

        OAuthBearerSaslServer saslServer = mock(OAuthBearerSaslServer.class);
        when(saslServer.getMechanismName()).thenReturn("OAUTHBEARER");
        when(saslServer.getAuthorizationID()).thenReturn(tokenInfo.principal());
        when(saslServer.getNegotiatedProperty("OAUTHBEARER.token")).thenReturn(tokenWithPayload);

        SaslAuthenticationContext authContext = mock(SaslAuthenticationContext.class);
        when(authContext.server()).thenReturn(saslServer);

        return (OAuthKafkaPrincipal) principalBuilder.build(authContext);
    }

    private AuthenticateCallbackHandler configureJwtSignatureValidator() {
        //JWTSignatureValidator validator = new JWTSignatureValidator("test-validator", JWKS_ENDPOINT, )
        JaasServerOauthValidatorCallbackHandler authHandler = new JaasServerOauthValidatorCallbackHandler();
        Map<String, String> jaasProps = new HashMap<>();
        jaasProps.put(ServerConfig.OAUTH_JWKS_ENDPOINT_URI, JWKS_ENDPOINT);
        jaasProps.put(ServerConfig.OAUTH_SSL_TRUSTSTORE_LOCATION, TRUSTSTORE_PATH);
        jaasProps.put(ServerConfig.OAUTH_SSL_TRUSTSTORE_PASSWORD, TRUSTSTORE_PASS);
        jaasProps.put(ServerConfig.OAUTH_VALID_ISSUER_URI, VALID_ISSUER_URI);
        jaasProps.put(ServerConfig.OAUTH_CHECK_ACCESS_TOKEN_TYPE, "false");

        Map<String, String> configs = new HashMap<>();
        authHandler.configure(configs, "OAUTHBEARER", Collections.singletonList(new AppConfigurationEntry("server", AppConfigurationEntry.LoginModuleControlFlag.REQUIRED, jaasProps)));
        return authHandler;
    }

    private OAuthBearerToken authenticate(AuthenticateCallbackHandler callbackHandler, String accessToken) throws IOException, UnsupportedCallbackException {
        OAuthBearerValidatorCallback callback = new OAuthBearerValidatorCallback(accessToken);
        Callback[] callbacks = new Callback[] {callback};
        callbackHandler.handle(callbacks);
        return callback.token();
    }

    /**
     * Test for the handling of improperly configured Authorization Services
     */
    void doMalformedGrantsTests() throws IOException, InterruptedException, TimeoutException {
        logStart("KeycloakAuthorizerTest :: Malformed Grants Tests");

        // make sure the token endpoint works fine
        changeAuthServerMode("token", "MODE_200");

        // login as some user - alice in our case, and get the token
        TokenInfo tokenInfo = login(TOKEN_ENDPOINT, USER_ALICE, USER_ALICE_PASS, 0);
        OAuthKafkaPrincipal principal = new OAuthKafkaPrincipal(KafkaPrincipal.USER_TYPE, USER_ALICE, TestTokenFactory.newTokenForUser(tokenInfo));

        // Mistyped resource type 'Topc' instead of 'Topic'
        addGrantsForToken(tokenInfo.token(), "[{\"scopes\":[\"Delete\",\"Write\",\"Describe\",\"Read\",\"Alter\",\"Create\",\"DescribeConfigs\",\"AlterConfigs\"],\"rsid\":\"ca6f195f-dbdc-48b7-a953-8e441d17f7fa\",\"rsname\":\"Topc:my-topic*\"}," +
                "{\"scopes\":[\"IdempotentWrite\"],\"rsid\":\"73af36e6-5796-43e7-8129-b57fe0bac7a1\",\"rsname\":\"Cluster:*\"}," +
                "{\"scopes\":[\"Describe\",\"Read\"],\"rsid\":\"141c56e8-1a85-40f3-b38a-f490bad76913\",\"rsname\":\"Group:*\"}]");

        List<Action> actions = new ArrayList<>();
        actions.add(new Action(
                AclOperation.CREATE,
                new ResourcePattern(ResourceType.TOPIC, "my-topic", PatternType.LITERAL),
                1, true, true));

        LogLineReader logReader = new LogLineReader(Common.LOG_PATH);
        // seek to the end of log file
        logReader.readNext();

        HashMap<String, String> props = configureAuthorizer();
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_REFRESH_PERIOD_SECONDS, "2");

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(props);


            AuthorizableRequestContext authzContext = newAuthorizableRequestContext(principal);

            LOG.info("Call authorize() - test grants record with invalid resource type 'Topc'");
            List<AuthorizationResult> result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: DENIED", AuthorizationResult.DENIED, result.get(0));

            // This is a first authorize() call on the KeycloakAuthorizer -> the grantsCache is empty
            LOG.info("Waiting for: unsupported segment type: Topc"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Failed to parse .* unsupported segment type: Topc");


            // malformed resource spec - no ':' in Topic;my-topic*
            addGrantsForToken(tokenInfo.token(), "[{\"scopes\":[\"Delete\",\"Write\",\"Describe\",\"Read\",\"Alter\",\"Create\",\"DescribeConfigs\",\"AlterConfigs\"],\"rsid\":\"ca6f195f-dbdc-48b7-a953-8e441d17f7fa\",\"rsname\":\"Topic;my-topic*\"}," +
                    "{\"scopes\":[\"IdempotentWrite\"],\"rsid\":\"73af36e6-5796-43e7-8129-b57fe0bac7a1\",\"rsname\":\"Cluster:*\"}," +
                    "{\"scopes\":[\"Describe\",\"Read\"],\"rsid\":\"141c56e8-1a85-40f3-b38a-f490bad76913\",\"rsname\":\"Group:*\"}]");

            // wait for grants refresh
            LOG.info("Waiting for: Done refreshing grants"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Response body .*Topic;my-topic");


            LOG.info("Call authorize() - test grants record with malformed resource spec 'Topic;my-topic*' (no ':')");
            result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: DENIED", AuthorizationResult.DENIED, result.get(0));

            LOG.info("Waiting for: doesn't follow TYPE:NAME pattern"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("part doesn't follow TYPE:NAME pattern");

            // malformed resource spec - '*' not at the end in 'Topic:*-topic'
            addGrantsForToken(tokenInfo.token(), "[{\"scopes\":[\"Delete\",\"Write\",\"Describe\",\"Read\",\"Alter\",\"Create\",\"DescribeConfigs\",\"AlterConfigs\"],\"rsid\":\"ca6f195f-dbdc-48b7-a953-8e441d17f7fa\",\"rsname\":\"Topic:*-topic\"}," +
                    "{\"scopes\":[\"IdempotentWrite\"],\"rsid\":\"73af36e6-5796-43e7-8129-b57fe0bac7a1\",\"rsname\":\"Cluster:*\"}," +
                    "{\"scopes\":[\"Describe\",\"Read\"],\"rsid\":\"141c56e8-1a85-40f3-b38a-f490bad76913\",\"rsname\":\"Group:*\"}]");

            // wait for grants refresh
            LOG.info("Waiting for: Done refreshing grants"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Response body .*Topic:\\*-topic");

            LOG.info("Call authorize() - test grants record with malformed resource spec 'Topic:*-topic' ('*' only interpreted as asterisk at the end of resource spec)");
            result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: DENIED", AuthorizationResult.DENIED, result.get(0));


            // unknown scope - 'Crate' (should be 'Create')
            addGrantsForToken(tokenInfo.token(), "[{\"scopes\":[\"Delete\",\"Write\",\"Describe\",\"Read\",\"Alter\",\"Crate\",\"DescribeConfigs\",\"AlterConfigs\"],\"rsid\":\"ca6f195f-dbdc-48b7-a953-8e441d17f7fa\",\"rsname\":\"Topic:my-topic*\"}," +
                    "{\"scopes\":[\"IdempotentWrite\"],\"rsid\":\"73af36e6-5796-43e7-8129-b57fe0bac7a1\",\"rsname\":\"Cluster:*\"}," +
                    "{\"scopes\":[\"Describe\",\"Read\"],\"rsid\":\"141c56e8-1a85-40f3-b38a-f490bad76913\",\"rsname\":\"Group:*\"}]");

            // wait for grants refresh
            LOG.info("Waiting for: Done refreshing grants"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Response body .*Crate");

            LOG.info("Call authorize() - test grants record with unknown / invalid scope 'Crate' (it should be 'Create')");
            result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: DENIED", AuthorizationResult.DENIED, result.get(0));
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    /**
     * Test for the semantic equality of grants - treat JSON array as a set
     */
    void doGrantsSemanticEqualsTest() throws Exception {
        logStart("KeycloakAuthorizerTest :: Test semantic equality of grants (JSON array -> set)");

        String grants1 = "[{\"scopes\":[\"Write\",\"Describe\"],\"rsid\":\"a92a050d-b4f1-4e91-ac65-dbe10f17ee36\",\"rsname\":\"Topic:x_*\"},{\"scopes\":[\"Read\",\"Write\",\"Delete\",\"Describe\",\"Alter\",\"Create\",\"DescribeConfigs\",\"AlterConfigs\"],\"rsid\":\"5098d4c2-0e7f-4121-8fd2-9964111370a2\",\"rsname\":\"Topic:a_*\"},{\"scopes\":[\"Read\",\"Describe\"],\"rsid\":\"916ed684-5bd0-42b1-b7ab-3b23448d3f50\",\"rsname\":\"Group:a_*\"},{\"scopes\":[\"IdempotentWrite\"],\"rsid\":\"d71850c3-5ea8-47ef-9a61-4fab9c1df363\",\"rsname\":\"kafka-cluster:my-cluster,Cluster:*\"}]";
        String grants2 = "[{\"scopes\":[\"Write\",\"Describe\",\"Create\"],\"rsid\":\"a92a050d-b4f1-4e91-ac65-dbe10f17ee36\",\"rsname\":\"Topic:x_*\"},{\"scopes\":[\"Read\",\"Write\",\"Delete\",\"Describe\",\"Alter\",\"Create\",\"DescribeConfigs\",\"AlterConfigs\"],\"rsid\":\"5098d4c2-0e7f-4121-8fd2-9964111370a2\",\"rsname\":\"Topic:a_*\"},{\"scopes\":[\"Read\",\"Describe\"],\"rsid\":\"916ed684-5bd0-42b1-b7ab-3b23448d3f50\",\"rsname\":\"Group:a_*\"},{\"scopes\":[\"IdempotentWrite\"],\"rsid\":\"d71850c3-5ea8-47ef-9a61-4fab9c1df363\",\"rsname\":\"kafka-cluster:my-cluster,Cluster:*\"}]";
        String grants3 = "[{\"scopes\":[\"Read\",\"Write\",\"Delete\",\"Describe\",\"Alter\",\"Create\",\"DescribeConfigs\",\"AlterConfigs\"],\"rsid\":\"5098d4c2-0e7f-4121-8fd2-9964111370a2\",\"rsname\":\"Topic:a_*\"},{\"scopes\":[\"Write\",\"Describe\",\"Create\"],\"rsid\":\"a92a050d-b4f1-4e91-ac65-dbe10f17ee36\",\"rsname\":\"Topic:x_*\"},{\"scopes\":[\"Read\",\"Describe\"],\"rsid\":\"916ed684-5bd0-42b1-b7ab-3b23448d3f50\",\"rsname\":\"Group:a_*\"},{\"scopes\":[\"IdempotentWrite\"],\"rsid\":\"d71850c3-5ea8-47ef-9a61-4fab9c1df363\",\"rsname\":\"kafka-cluster:my-cluster,Cluster:*\"}]";

        // make sure the token endpoint works fine
        changeAuthServerMode("token", "MODE_200");

        // login as some user - alice in our case, and get the token
        TokenInfo tokenInfo = login(TOKEN_ENDPOINT, USER_ALICE, USER_ALICE_PASS, 0);
        OAuthKafkaPrincipal principal = new OAuthKafkaPrincipal(KafkaPrincipal.USER_TYPE, USER_ALICE, TestTokenFactory.newTokenForUser(tokenInfo));

        // Set grants for the user to `grants1`
        addGrantsForToken(tokenInfo.token(), grants1);

        List<Action> actions = new ArrayList<>();
        actions.add(new Action(
                AclOperation.CREATE,
                new ResourcePattern(ResourceType.TOPIC, "x_topic", PatternType.LITERAL),
                1, true, true));

        LogLineReader logReader = new LogLineReader(Common.LOG_PATH);
        // seek to the end of log file
        logReader.readNext();

        HashMap<String, String> props = configureAuthorizer();
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_REFRESH_PERIOD_SECONDS, "2");

        try (KeycloakAuthorizer authorizer = new KeycloakAuthorizer()) {
            authorizer.configure(props);


            AuthorizableRequestContext authzContext = newAuthorizableRequestContext(principal);

            LOG.info("Call authorize() - create x_topic");
            List<AuthorizationResult> result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: DENIED", AuthorizationResult.DENIED, result.get(0));

            // Check log for 'Saving non-null grants for user: alice'
            LOG.info("Waiting for: Saving non-null grants"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Saving non-null grants for user: alice");

            // set grants for the user to `grants2` which are semantically different from `grants1`
            addGrantsForToken(tokenInfo.token(), grants2);

            // wait for the refresh job to fetch the new grants
            // Check log for 'Grants have changed for user: alice'
            LOG.info("Waiting for: Grants have changed"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Grants have changed for user: alice");

            // set grants for the user to `grants3` which are semantically equal to `grants2`
            addGrantsForToken(tokenInfo.token(), grants3);

            // wait for the refresh job to fetch the new grants
            LOG.info("Waiting for: Refreshing grants to start"); // Make sure to not repeat the below condition in the string here
            logReader.waitFor("Refreshing authorization grants");

            // Check log for 'Done refreshing grants' and there should be no preceding line containing 'Grants have changed for user'
            // wait for refresh grants job to complete
            LOG.info("Waiting for grants refresh to complete"); // Make sure to not repeat the below condition in the string here
            List<String> lines = logReader.waitFor("Done refreshing grants");

            Assert.assertFalse("Grants have changed again ?!?", checkLogForRegex(lines, "Grants have changed for user"));

            result = authorizer.authorize(authzContext, actions);
            Assert.assertEquals("Authz result: ALLOWED", AuthorizationResult.ALLOWED, result.get(0));
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    void doSingletonTest() throws Exception {
        logStart("KeycloakAuthorizerTest :: Ensure that multiple instantiated KeycloakAuthorizers share a single instance of KeycloakRBACAuthorizer");

        HashMap<String, String> config = configureAuthorizer();

        LogLineReader logReader = new LogLineReader(Common.LOG_PATH);
        logReader.readNext();

        List<String> lines;
        try (KeycloakAuthorizer authorizer1 = new KeycloakAuthorizer();
             KeycloakAuthorizer authorizer2 = new KeycloakAuthorizer()) {

            authorizer1.configure(config);
            authorizer2.configure(config);

            lines = logReader.readNext();

            List<String> keycloakAuthorizerLines = lines.stream().filter(line -> line.contains("Configured KeycloakAuthorizer@")).collect(Collectors.toList());
            List<String> keycloakRBACAuthorizerLines = lines.stream().filter(line -> line.contains("Configured KeycloakRBACAuthorizer@")).collect(Collectors.toList());

            Assert.assertEquals("Configured KeycloakAuthorizer", 2, keycloakAuthorizerLines.size());
            Assert.assertEquals("Configured KeycloakRBACAuthorizer", 1, keycloakRBACAuthorizerLines.size());
        }

        TestAuthzUtil.clearKeycloakAuthorizerService();
    }

    private static Future<List<AuthorizationResult>> submitAuthorizationCall(KeycloakAuthorizer authorizer, AuthorizableRequestContext ctx, ExecutorService executorService, String topic) {
        return executorService.submit(() -> {
            List<Action> actions = new ArrayList<>();
            actions.add(new Action(
                    AclOperation.CREATE,
                    new ResourcePattern(ResourceType.TOPIC, topic, PatternType.LITERAL),
                    1, true, true));

            return authorizer.authorize(ctx, actions);
        });
    }

    private HashMap<String, String> configureAuthorizer() {
        return configureAuthorizer(CLIENT_SRV, TRUSTSTORE_PATH, TRUSTSTORE_PASS);
    }

    static HashMap<String, String> configureAuthorizer(String clientSrv, String trustStorePath, String trustsStorePass) {
        HashMap<String, String> props = new HashMap<>();
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_SSL_TRUSTSTORE_LOCATION, trustStorePath);
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_SSL_TRUSTSTORE_PASSWORD, trustsStorePass);
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_SSL_TRUSTSTORE_TYPE, "pkcs12");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_ENABLE_METRICS, "true");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_TOKEN_ENDPOINT_URI, "https://mockoauth:8090/grants");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_CLIENT_ID, clientSrv);
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_KAFKA_CLUSTER_NAME, "my-cluster");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_DELEGATE_TO_KAFKA_ACL, "false");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_READ_TIMEOUT_SECONDS, "45");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_CONNECT_TIMEOUT_SECONDS, "10");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_REFRESH_POOL_SIZE, "2");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_GRANTS_REFRESH_PERIOD_SECONDS, "60");
        props.put(AuthzConfig.STRIMZI_AUTHORIZATION_HTTP_RETRIES, "1");
        props.put("super.users", "User:admin;User:service-account-kafka");
        props.put("principal.builder.class", "io.strimzi.kafka.oauth.server.OAuthKafkaPrincipalBuilder");
        return props;
    }

    private AuthorizableRequestContext newAuthorizableRequestContext(KafkaPrincipal principal) {
        AuthorizableRequestContext ctx = mock(AuthorizableRequestContext.class);
        when(ctx.listenerName()).thenReturn("JWT");
        when(ctx.securityProtocol()).thenReturn(SecurityProtocol.SASL_PLAINTEXT);
        when(ctx.principal()).thenReturn(principal);
        when(ctx.clientId()).thenReturn(CLIENT_CLI);
        return ctx;
    }

    private TokenInfo login(String tokenEndpoint, String user, String userPass, int retries) throws IOException {
        return OAuthAuthenticator.loginWithPassword(
                URI.create(tokenEndpoint),
                SSLUtil.createSSLFactory(TRUSTSTORE_PATH, null, TRUSTSTORE_PASS, null, null),
                null,
                user,
                userPass,
                CLIENT_CLI,
                null,
                true,
                new PrincipalExtractor(),
                "all",
                null,
                60,
                60,
                retries,
                0,
                true);
    }

    private void logStart(String msg) {
        System.out.println();
        System.out.println("========    "  + msg);
        System.out.println();

        // Log to file as well for better readability
        LOG.info("========    " + msg);
    }
}
