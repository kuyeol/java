/*
 * Copyright 2017-2022, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.kafka.oauth.validator;

import io.strimzi.kafka.oauth.services.ValidatorKey;
import org.junit.Assert;
import org.junit.Test;

public class ConfigIdHashTest {

    @Test
    public void testValidatorKey() {

        ValidatorKey vkey = getKey(null, null);
        ValidatorKey vkey2 = getKey(null, null);

        Assert.assertEquals("Config id hash mismatch", "f433dbf8", vkey.getConfigIdHash());
        Assert.assertEquals("Config id hash should be the same", vkey.getConfigIdHash(), vkey2.getConfigIdHash());

        ValidatorKey key3 = getKey("group", null);
        ValidatorKey key4 = getKey(null, "group");

        Assert.assertEquals("Config id hash mismatch", "024dcc79", key3.getConfigIdHash());
        Assert.assertEquals("Config id hash mismatch", "dfec1585", key4.getConfigIdHash());
    }

    ValidatorKey getKey(String groupQuery, String groupDelimiter) {
        return new ValidatorKey.IntrospectionValidatorKey(
                "example-client",
                "example-client-secret",
                null,
                "http://mockoauth:8080",
                null,
                "@.aud='http://example.com/'",
                "preferred_username",
                null,
                null,
                groupQuery,
                groupDelimiter,
                null,
                null,
                null,
                null,
                false,
                "http://mockoauth:8080/introspect",
                null,
                null,
                60,
                60,
                true,
                0,
                0,
                false);
    }
}
