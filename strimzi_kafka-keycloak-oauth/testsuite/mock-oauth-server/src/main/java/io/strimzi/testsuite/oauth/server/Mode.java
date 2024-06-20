/*
 * Copyright 2017-2021, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.testsuite.oauth.server;

import java.util.Locale;

enum Mode {
    MODE_200,
    /** Used by jwks endpoint, which by default does not require 'Authorization' header, but requires it if this mode is enabled*/
    MODE_200_PROTECTED,
    /** Used by introspection endpoint, which by default requires 'Authorization' header, but not if this mode is enabled */
    MODE_200_UNPROTECTED,
    MODE_400,
    MODE_401,
    MODE_403,
    MODE_404,
    MODE_500,
    MODE_503,
    MODE_FAILING_500,
    MODE_OFF,
    MODE_STALL,
    MODE_200_DELAYED,
    MODE_CERT_ONE_ON,
    MODE_CERT_TWO_ON,
    MODE_EXPIRED_CERT_ON,
    MODE_JWKS_RSA_WITH_SIG_USE,
    MODE_JWKS_RSA_WITHOUT_SIG_USE;


    public static Mode fromString(String value) {
        return Mode.valueOf(value.toUpperCase(Locale.ROOT));
    }

}
