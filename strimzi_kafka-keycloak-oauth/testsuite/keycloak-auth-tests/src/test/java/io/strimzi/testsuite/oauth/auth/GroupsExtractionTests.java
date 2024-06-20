/*
 * Copyright 2017-2020, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.testsuite.oauth.auth;

import io.strimzi.kafka.oauth.client.ClientConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static io.strimzi.testsuite.oauth.auth.Common.buildProducerConfigOAuthBearer;
import static io.strimzi.testsuite.oauth.common.TestUtil.getContainerLogsForString;

public class GroupsExtractionTests {

    private static final Logger log = LoggerFactory.getLogger(GroupsExtractionTests.class);

    private final String kafkaContainer;

    GroupsExtractionTests(String kafkaContainer) {
        this.kafkaContainer = kafkaContainer;
    }

    void doTests() throws Exception {
        groupsExtractionWithJwtTest();
        groupsExtractionWithIntrospectionTest();
    }

    private void groupsExtractionWithJwtTest() throws Exception {
        System.out.println("    ====    KeycloakAuthenticationTest :: groupsExtractionWithJwtTest");
        runTest("kafka:9098", "principalName: service-account-team-b-client, groups: [offline_access, Dev Team B]");
    }

    private void groupsExtractionWithIntrospectionTest() throws Exception {
        System.out.println("    ====    KeycloakAuthenticationTest :: groupsExtractionWithIntrospectionTest");
        runTest("kafka:9099", "principalName: service-account-team-b-client, groups: [kafka-user]");
    }

    private void runTest(String kafkaBootstrap, String logFilter) throws Exception {

        final String hostPort = "keycloak:8080";
        final String realm = "kafka-authz";

        final String tokenEndpointUri = "http://" + hostPort + "/realms/" + realm + "/protocol/openid-connect/token";

        // logging in as 'team-b-client' should succeed - iss check, clientId check, aud check, resource_access check should all pass

        Map<String, String> oauthConfig = new HashMap<>();
        oauthConfig.put(ClientConfig.OAUTH_TOKEN_ENDPOINT_URI, tokenEndpointUri);
        oauthConfig.put(ClientConfig.OAUTH_CLIENT_ID, "team-b-client");
        oauthConfig.put(ClientConfig.OAUTH_CLIENT_SECRET, "team-b-client-secret");
        oauthConfig.put(ClientConfig.OAUTH_USERNAME_CLAIM, "preferred_username");

        Properties producerProps = buildProducerConfigOAuthBearer(kafkaBootstrap, oauthConfig);
        Producer<String, String> producer = new KafkaProducer<>(producerProps);

        final String topic = "KeycloakAuthenticationTest-customClaimCheckWithJwtTest";


        producer.send(new ProducerRecord<>(topic, "The Message")).get();
        log.debug("Produced The Message");

        // get kafka log and make sure groups were extracted during authentication
        List<String> lines = getContainerLogsForString(kafkaContainer, logFilter);
        Assert.assertTrue("Kafka log should contain: \"" + logFilter + "\"", lines.size() > 0);
    }

}
