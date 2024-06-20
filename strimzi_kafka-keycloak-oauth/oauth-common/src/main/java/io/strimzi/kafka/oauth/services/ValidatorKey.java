/*
 * Copyright 2017-2020, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.kafka.oauth.services;

import io.strimzi.kafka.oauth.common.IOUtil;

import java.util.Objects;

import static io.strimzi.kafka.oauth.common.LogUtil.mask;
import static io.strimzi.kafka.oauth.common.LogUtil.singleQuote;

/**
 * The class that holds the validator configuration and is used to compare different configurations for equality.
 * It also calculates a unique identifier based on the configuration that is stable across application restarts.
 * <p>
 * This mechanism allows sharing a single validator across multiple listeners, as long as they are configured with same config parameter values
 */
public class ValidatorKey {

    private final String clientId;
    private final String clientSecret;
    private final String bearerToken;
    private final String validIssuerUri;
    private final String audience;
    private final String customClaimCheck;
    private final String usernameClaim;
    private final String fallbackUsernameClaim;
    private final String fallbackUsernamePrefix;
    private final String groupQuery;
    private final String groupDelimiter;

    private final String sslTruststore;
    private final String sslStorePassword;
    private final String sslStoreType;
    private final String sslRandom;
    private final boolean hasHostnameVerifier;

    private final int connectTimeout;
    private final int readTimeout;
    private final boolean enableMetrics;
    private final boolean includeAcceptHeader;

    private final String configIdHash;

    @SuppressWarnings("checkstyle:ParameterNumber")
    ValidatorKey(String clientId,
            String clientSecret,
            String bearerToken,
            String validIssuerUri,
            String audience,
            String customClaimCheck,
            String usernameClaim,
            String fallbackUsernameClaim,
            String fallbackUsernamePrefix,
            String groupQuery,
            String groupDelimiter,
            String sslTruststore,
            String sslStorePassword,
            String sslStoreType,
            String sslRandom,
            boolean hasHostnameVerifier,
            int connectTimeout,
            int readTimeout,
            boolean enableMetrics,
            boolean includeAcceptHeader) {

        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.bearerToken = bearerToken;
        this.validIssuerUri = validIssuerUri;
        this.audience = audience;
        this.customClaimCheck = customClaimCheck;
        this.usernameClaim = usernameClaim;
        this.fallbackUsernameClaim = fallbackUsernameClaim;
        this.fallbackUsernamePrefix = fallbackUsernamePrefix;
        this.groupQuery = groupQuery;
        this.groupDelimiter = groupDelimiter;
        this.sslTruststore = sslTruststore;
        this.sslStorePassword = sslStorePassword;
        this.sslStoreType = sslStoreType;
        this.sslRandom = sslRandom;
        this.hasHostnameVerifier = hasHostnameVerifier;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.enableMetrics = enableMetrics;
        this.includeAcceptHeader = includeAcceptHeader;

        this.configIdHash = IOUtil.hashForObjects(
                clientId,
                clientSecret,
                bearerToken,
                validIssuerUri,
                audience,
                customClaimCheck,
                usernameClaim,
                fallbackUsernameClaim,
                fallbackUsernamePrefix,
                groupQuery,
                groupDelimiter,
                sslTruststore,
                sslStorePassword,
                sslStoreType,
                sslRandom,
                hasHostnameVerifier,
                connectTimeout,
                readTimeout,
                enableMetrics,
                includeAcceptHeader);
    }

    @SuppressWarnings({"checkstyle:CyclomaticComplexity"})
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidatorKey)) return false;
        ValidatorKey that = (ValidatorKey) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(clientSecret, that.clientSecret) &&
                Objects.equals(bearerToken, that.bearerToken) &&
                hasHostnameVerifier == that.hasHostnameVerifier &&
                Objects.equals(validIssuerUri, that.validIssuerUri) &&
                Objects.equals(audience, that.audience) &&
                Objects.equals(customClaimCheck, that.customClaimCheck) &&
                Objects.equals(usernameClaim, that.usernameClaim) &&
                Objects.equals(fallbackUsernameClaim, that.fallbackUsernameClaim) &&
                Objects.equals(fallbackUsernamePrefix, that.fallbackUsernamePrefix) &&
                Objects.equals(groupQuery, that.groupQuery) &&
                Objects.equals(groupDelimiter, that.groupDelimiter) &&
                Objects.equals(sslTruststore, that.sslTruststore) &&
                Objects.equals(sslStorePassword, that.sslStorePassword) &&
                Objects.equals(sslStoreType, that.sslStoreType) &&
                Objects.equals(sslRandom, that.sslRandom) &&
                Objects.equals(connectTimeout, that.connectTimeout) &&
                Objects.equals(readTimeout, that.readTimeout) &&
                Objects.equals(enableMetrics, that.enableMetrics) &&
                Objects.equals(includeAcceptHeader, that.includeAcceptHeader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                clientId,
                clientSecret,
                bearerToken,
                validIssuerUri,
                audience,
                customClaimCheck,
                usernameClaim,
                fallbackUsernameClaim,
                fallbackUsernamePrefix,
                groupQuery,
                groupDelimiter,
                sslTruststore,
                sslStorePassword,
                sslStoreType,
                sslRandom,
                hasHostnameVerifier,
                connectTimeout,
                readTimeout,
                enableMetrics,
                includeAcceptHeader);
    }

    /**
     * Get the calculated configuration hash for this instance
     *
     * @return a hash string used to determine equality of two different configurations
     */
    public String getConfigIdHash() {
        return configIdHash;
    }

    /**
     * A <code>ValidatorKey</code> for {@link io.strimzi.kafka.oauth.validator.JWTSignatureValidator}
     */
    public static class JwtValidatorKey extends ValidatorKey {

        private final String jwksEndpointUri;
        private final int jwksRefreshSeconds;
        private final int jwksExpirySeconds;
        private final int jwksRefreshMinPauseSeconds;
        private final boolean checkAccessTokenType;
        private final boolean failFast;
        private final boolean jwksIgnoreKeyUse;

        private final String configIdHash;

        /**
         * Create a new instance. Arguments have to include all validator config options.
         *
         * @param clientId clientId
         * @param clientSecret clientSecret
         * @param bearerToken bearerToken
         * @param validIssuerUri validIssuerUri
         * @param audience audience
         * @param customClaimCheck customClaimCheck
         * @param usernameClaim usernameClaim
         * @param fallbackUsernameClaim fallbackUsernameClaim
         * @param fallbackUsernamePrefix fallbackUsernamePrefix
         * @param groupQuery groupQuery
         * @param groupDelimiter groupDelimiter
         * @param sslTruststore sslTruststore
         * @param sslStorePassword sslStorePassword
         * @param sslStoreType sslStoreType
         * @param sslRandom sslRandom
         * @param hasHostnameVerifier hasHostnameVerifier
         * @param jwksEndpointUri jwksEndpointUri
         * @param jwksRefreshSeconds jwksRefreshSeconds
         * @param jwksExpirySeconds jwksExpirySeconds
         * @param jwksRefreshMinPauseSeconds jwksRefreshMinPauseSeconds
         * @param jwksIgnoreKeyUse jwksIgnoreKeyUse
         * @param checkAccessTokenType checkAccessTokenType
         * @param connectTimeout connectTimeout
         * @param readTimeout readTimeout
         * @param enableMetrics enableMetrics
         * @param failFast failFast
         * @param includeAcceptHeader includeAcceptHeader
         */
        @SuppressWarnings("checkstyle:parameternumber")
        public JwtValidatorKey(String clientId,
                               String clientSecret,
                               String bearerToken,
                               String validIssuerUri,
                               String audience,
                               String customClaimCheck,
                               String usernameClaim,
                               String fallbackUsernameClaim,
                               String fallbackUsernamePrefix,
                               String groupQuery,
                               String groupDelimiter,
                               String sslTruststore,
                               String sslStorePassword,
                               String sslStoreType,
                               String sslRandom,
                               boolean hasHostnameVerifier,

                               String jwksEndpointUri,
                               int jwksRefreshSeconds,
                               int jwksExpirySeconds,
                               int jwksRefreshMinPauseSeconds,
                               boolean jwksIgnoreKeyUse,
                               boolean checkAccessTokenType,
                               int connectTimeout,
                               int readTimeout,
                               boolean enableMetrics,
                               boolean failFast,
                               boolean includeAcceptHeader) {

            super(clientId,
                    clientSecret,
                    bearerToken,
                    validIssuerUri,
                    audience,
                    customClaimCheck,
                    usernameClaim,
                    fallbackUsernameClaim,
                    fallbackUsernamePrefix,
                    groupQuery,
                    groupDelimiter,
                    sslTruststore,
                    sslStorePassword,
                    sslStoreType,
                    sslRandom,
                    hasHostnameVerifier,
                    connectTimeout,
                    readTimeout,
                    enableMetrics,
                    includeAcceptHeader);
            this.jwksEndpointUri = jwksEndpointUri;
            this.jwksRefreshSeconds = jwksRefreshSeconds;
            this.jwksExpirySeconds = jwksExpirySeconds;
            this.jwksRefreshMinPauseSeconds = jwksRefreshMinPauseSeconds;
            this.jwksIgnoreKeyUse = jwksIgnoreKeyUse;
            this.checkAccessTokenType = checkAccessTokenType;
            this.failFast = failFast;

            this.configIdHash = IOUtil.hashForObjects(super.getConfigIdHash(),
                    jwksEndpointUri,
                    jwksRefreshSeconds,
                    jwksExpirySeconds,
                    jwksRefreshMinPauseSeconds,
                    jwksIgnoreKeyUse,
                    checkAccessTokenType,
                    failFast);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            JwtValidatorKey that = (JwtValidatorKey) o;
            return jwksRefreshSeconds == that.jwksRefreshSeconds &&
                    jwksExpirySeconds == that.jwksExpirySeconds &&
                    jwksRefreshMinPauseSeconds == that.jwksRefreshMinPauseSeconds &&
                    jwksIgnoreKeyUse == that.jwksIgnoreKeyUse &&
                    checkAccessTokenType == that.checkAccessTokenType &&
                    failFast == that.failFast &&
                    Objects.equals(jwksEndpointUri, that.jwksEndpointUri);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(),
                    jwksEndpointUri,
                    jwksRefreshSeconds,
                    jwksExpirySeconds,
                    jwksRefreshMinPauseSeconds,
                    jwksIgnoreKeyUse,
                    checkAccessTokenType,
                    failFast);
        }

        @Override
        public String getConfigIdHash() {
            return configIdHash;
        }

        @Override
        public String toString() {
            return "JwtValidatorKey {clientId: " + singleQuote(super.clientId)
                    + ", clientSecret: " + singleQuote(mask(super.clientSecret))
                    + ", bearerToken: " + singleQuote(mask(super.bearerToken))
                    + ", validIssuerUri: " + singleQuote(super.validIssuerUri)
                    + ", audience: " + singleQuote(super.audience)
                    + ", customClaimCheck: " + singleQuote(super.customClaimCheck)
                    + ", usernameClaim: " + singleQuote(super.usernameClaim)
                    + ", fallbackUsernameClaim: " + singleQuote(super.fallbackUsernameClaim)
                    + ", fallbackUsernamePrefix: " + singleQuote(super.fallbackUsernamePrefix)
                    + ", groupQuery: " + singleQuote(super.groupQuery)
                    + ", groupDelimiter: [" + super.groupDelimiter
                    + "], sslTruststore: " + singleQuote(super.sslTruststore)
                    + ", sslStorePassword: " + singleQuote(mask(super.sslStorePassword))
                    + ", sslStoreType: " + singleQuote(super.sslStoreType)
                    + ", sslRandom: " + singleQuote(super.sslRandom)
                    + ", hasHostnameVerifier: " + super.hasHostnameVerifier
                    + ", connectTimeout: " + super.connectTimeout
                    + ", readTimeout: " + super.readTimeout
                    + ", enableMetrics: " + super.enableMetrics
                    + ", includeAcceptHeader: " + super.includeAcceptHeader
                    + ", jwksEndpointUri: " + singleQuote(jwksEndpointUri)
                    + ", jwksRefreshSeconds: " + jwksRefreshSeconds
                    + ", jwksExpirySeconds: " + jwksExpirySeconds
                    + ", jwksRefreshMinPauseSeconds: " + jwksRefreshMinPauseSeconds
                    + ", jwksIgnoreKeyUse: " + jwksIgnoreKeyUse
                    + ", checkAccessTokenType: " + checkAccessTokenType
                    + ", failFast: " + failFast
                    + "}";
        }
    }

    /**
     * A <code>ValidatorKey</code> for {@link io.strimzi.kafka.oauth.validator.OAuthIntrospectionValidator}
     */
    public static class IntrospectionValidatorKey extends ValidatorKey {

        private final String introspectionEndpoint;
        private final String userInfoEndpoint;
        private final String validTokenType;
        private final int retries;
        private final long retryPauseMillis;
        private final String configIdHash;

        /**
         * Create a new instance. Arguments have to include all validator config options.
         *
         * @param clientId clientId
         * @param clientSecret clientSecret
         * @param bearerToken bearerToken
         * @param validIssuerUri validIssuerUri
         * @param audience audience
         * @param customClaimCheck customClaimCheck
         * @param usernameClaim usernameClaim
         * @param fallbackUsernameClaim fallbackUsernameClaim
         * @param fallbackUsernamePrefix fallbackUsernamePrefix
         * @param groupQuery groupQuery
         * @param groupDelimiter groupDelimiter
         * @param sslTruststore sslTruststore
         * @param sslStorePassword sslStorePassword
         * @param sslStoreType sslStoreType
         * @param sslRandom sslRandom
         * @param hasHostnameVerifier hasHostnameVerifier
         * @param introspectionEndpoint introspectionEndpoint
         * @param userInfoEndpoint userInfoEndpoint
         * @param validTokenType validTokenType
         * @param connectTimeout connectTimeout
         * @param readTimeout readTimeout
         * @param enableMetrics enableMetrics
         * @param retries retries
         * @param retryPauseMillis retryPauseMillis
         * @param includeAcceptHeader includeAcceptHeader
         */
        @SuppressWarnings("checkstyle:parameternumber")
        public IntrospectionValidatorKey(String clientId,
                                  String clientSecret,
                                  String bearerToken,
                                  String validIssuerUri,
                                  String audience,
                                  String customClaimCheck,
                                  String usernameClaim,
                                  String fallbackUsernameClaim,
                                  String fallbackUsernamePrefix,
                                  String groupQuery,
                                  String groupDelimiter,
                                  String sslTruststore,
                                  String sslStorePassword,
                                  String sslStoreType,
                                  String sslRandom,
                                  boolean hasHostnameVerifier,

                                  String introspectionEndpoint,
                                  String userInfoEndpoint,
                                  String validTokenType,
                                  int connectTimeout,
                                  int readTimeout,
                                  boolean enableMetrics,
                                  int retries,
                                  long retryPauseMillis,
                                  boolean includeAcceptHeader) {

            super(clientId,
                    clientSecret,
                    bearerToken,
                    validIssuerUri,
                    audience,
                    customClaimCheck,
                    usernameClaim,
                    fallbackUsernameClaim,
                    fallbackUsernamePrefix,
                    groupQuery,
                    groupDelimiter,
                    sslTruststore,
                    sslStorePassword,
                    sslStoreType,
                    sslRandom,
                    hasHostnameVerifier,
                    connectTimeout,
                    readTimeout,
                    enableMetrics,
                    includeAcceptHeader);
            this.introspectionEndpoint = introspectionEndpoint;
            this.userInfoEndpoint = userInfoEndpoint;
            this.validTokenType = validTokenType;
            this.retries = retries;
            this.retryPauseMillis = retryPauseMillis;

            this.configIdHash = IOUtil.hashForObjects(super.getConfigIdHash(),
                    introspectionEndpoint,
                    userInfoEndpoint,
                    validTokenType,
                    clientId,
                    clientSecret,
                    retries,
                    retryPauseMillis);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            IntrospectionValidatorKey that = (IntrospectionValidatorKey) o;
            return Objects.equals(introspectionEndpoint, that.introspectionEndpoint) &&
                    Objects.equals(userInfoEndpoint, that.userInfoEndpoint) &&
                    Objects.equals(validTokenType, that.validTokenType) &&
                    Objects.equals(retries, that.retries) &&
                    Objects.equals(retryPauseMillis, that.retryPauseMillis);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(),
                    introspectionEndpoint,
                    userInfoEndpoint,
                    validTokenType,
                    retries,
                    retryPauseMillis);
        }

        @Override
        public String getConfigIdHash() {
            return configIdHash;
        }

        @Override
        public String toString() {
            return "IntrospectionValidatorKey {clientId: " + singleQuote(super.clientId)
                    + ", clientSecret: " + singleQuote(mask(super.clientSecret))
                    + ", bearerToken: " + singleQuote(mask(super.bearerToken))
                    + ", validIssuerUri: " + singleQuote(super.validIssuerUri)
                    + ", audience: " + singleQuote(super.audience)
                    + ", customClaimCheck: " + singleQuote(super.customClaimCheck)
                    + ", usernameClaim: " + singleQuote(super.usernameClaim)
                    + ", fallbackUsernameClaim: " + singleQuote(super.fallbackUsernameClaim)
                    + ", fallbackUsernamePrefix: " + singleQuote(super.fallbackUsernamePrefix)
                    + ", groupQuery: " + singleQuote(super.groupQuery)
                    + ", groupDelimiter: [" + super.groupDelimiter
                    + "], sslTruststore: " + singleQuote(super.sslTruststore)
                    + ", sslStorePassword: " + singleQuote(mask(super.sslStorePassword))
                    + ", sslStoreType: " + singleQuote(super.sslStoreType)
                    + ", sslRandom: " + singleQuote(super.sslRandom)
                    + ", hasHostnameVerifier: " + super.hasHostnameVerifier
                    + ", connectTimeout: " + super.connectTimeout
                    + ", readTimeout: " + super.readTimeout
                    + ", enableMetrics: " + super.enableMetrics
                    + ", includeAcceptHeader: " + super.includeAcceptHeader
                    + ", introspectionEndpoint: " + singleQuote(introspectionEndpoint)
                    + ", userInfoEndpoint: " + singleQuote(userInfoEndpoint)
                    + ", validTokenType: " + singleQuote(validTokenType)
                    + ", retries: " + retries
                    + ", retryPauseMillis: " + retryPauseMillis
                    + "}";
        }
    }
}
