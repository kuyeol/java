/*
 * Copyright 2017-2021, Strimzi authors.
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

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.strimzi.testsuite.oauth.auth.Common.buildProducerConfigOAuthBearer;
import static io.strimzi.testsuite.oauth.auth.Common.buildProducerConfigPlain;
import static io.strimzi.testsuite.oauth.auth.Common.buildProducerConfigScram;

public class MultiSaslTests {

    private static final Logger log = LoggerFactory.getLogger(MultiSaslTests.class);

    private static final String KAFKA_PLAIN_LISTENER = "kafka:9100";
    private static final String KAFKA_SCRAM_LISTENER = "kafka:9101";
    private static final String KAFKA_JWT_LISTENER = "kafka:9092";
    private static final String KAFKA_JWTPLAIN_LISTENER = "kafka:9096";

    public static void doTests() throws Exception {

        // bobby:bobby-secret
        String username = "bobby";
        String password = "bobby-secret";

        // producing to PLAIN listener using SASL/PLAIN should succeed
        Properties producerProps = producerConfigPlain(KAFKA_PLAIN_LISTENER, username, password);
        produceToTopic("KeycloakAuthenticationTest-multiSaslTest-plain", producerProps);

        // producing to SCRAM listener using SASL_SCRAM-SHA-512 should fail
        producerProps = producerConfigScram(KAFKA_SCRAM_LISTENER, username, password);
        try {
            produceToTopic("KeycloakAuthenticationTest-multiSaslTest-scram", producerProps);
            Assert.fail("Should have failed");
        } catch (Exception ignored) {
        }


        // alice:alice-secret
        username = "alice";
        password = "alice-secret";

        // producing to PLAIN listener using SASL/PLAIN should fail
        producerProps = producerConfigPlain(KAFKA_PLAIN_LISTENER, username, password);
        try {
            produceToTopic("KeycloakAuthenticationTest-multiSaslTest-plain", producerProps);
            Assert.fail("Should have failed");
        } catch (Exception ignored) {
        }

        // producing to SCRAM listener using SASL_SCRAM-SHA-512 should succeed
        producerProps = producerConfigScram(KAFKA_SCRAM_LISTENER, username, password);
        produceToTopic("KeycloakAuthenticationTest-multiSaslTest-scram", producerProps);

        // OAuth authentication should fail
        try {
            Common.loginWithUsernamePassword(
                    URI.create("http://keycloak:8080/realms/demo-ec/protocol/openid-connect/token"),
                    username, password, "kafka");

            Assert.fail("Should have failed");
        } catch (Exception ignored) {
        }


        // alice:alice-password
        username = "alice";
        password = "alice-password";

        // producing to PLAIN listener using SASL/PLAIN should fail
        producerProps = producerConfigPlain(KAFKA_PLAIN_LISTENER, username, password);
        try {
            produceToTopic("KeycloakAuthenticationTest-multiSaslTest-plain", producerProps);
            Assert.fail("Should have failed");
        } catch (Exception ignored) {
        }

        // producing to SCRAM listener using SASL_SCRAM-SHA-512 should fail
        producerProps = producerConfigScram(KAFKA_SCRAM_LISTENER, username, password);
        try {
            produceToTopic("KeycloakAuthenticationTest-multiSaslTest-scram", producerProps);
            Assert.fail("Should have failed");
        } catch (Exception ignored) {
        }

        // producing to JWT listener using SASL/OAUTHBEARER using access token should succeed
        String accessToken = Common.loginWithUsernamePassword(
                URI.create("http://keycloak:8080/realms/demo-ec/protocol/openid-connect/token"),
                username, password, "kafka");
        producerProps = producerConfigOAuthBearerAccessToken(KAFKA_JWT_LISTENER, accessToken);
        produceToTopic("KeycloakAuthenticationTest-multiSaslTest-oauthbearer", producerProps);

        // producing to JWTPLAIN listener using SASL/PLAIN using $accessToken should succeed
        accessToken = Common.loginWithUsernamePassword(
                URI.create("http://keycloak:8080/realms/kafka-authz/protocol/openid-connect/token"),
                username, password, "kafka-cli");
        producerProps = producerConfigPlain(KAFKA_JWTPLAIN_LISTENER, username, "$accessToken:" + accessToken);
        produceToTopic("KeycloakAuthenticationTest-multiSaslTest-oauth-over-plain", producerProps);
    }

    private static Properties producerConfigScram(String kafkaBootstrap, String username, String password) {
        Map<String, String> scramConfig = new HashMap<>();
        scramConfig.put("username", username);
        scramConfig.put("password", password);

        Properties producerProps = buildProducerConfigScram(kafkaBootstrap, scramConfig);
        return producerProps;
    }

    private static Properties producerConfigPlain(String kafkaBootstrap, String username, String password) {
        Map<String, String> scramConfig = new HashMap<>();
        scramConfig.put("username", username);
        scramConfig.put("password", password);

        Properties producerProps = buildProducerConfigPlain(kafkaBootstrap, scramConfig);
        return producerProps;
    }

    private static Properties producerConfigOAuthBearerAccessToken(String kafkaBootstrap, String accessToken) {
        Map<String, String> oauthConfig = new HashMap<>();
        oauthConfig.put(ClientConfig.OAUTH_ACCESS_TOKEN, accessToken);
        oauthConfig.put(ClientConfig.OAUTH_USERNAME_CLAIM, "preferred_username");

        Properties producerProps = buildProducerConfigOAuthBearer(kafkaBootstrap, oauthConfig);
        return producerProps;
    }

    private static void produceToTopic(String topic, Properties config) throws Exception {

        Producer<String, String> producer = new KafkaProducer<>(config);

        producer.send(new ProducerRecord<>(topic, "The Message")).get();
        log.debug("Produced The Message");
    }
}
