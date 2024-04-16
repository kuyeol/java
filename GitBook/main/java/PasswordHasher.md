# PasswordHasher

package org.acme.reactive.crud.security;

import java.security.InvalidKeyException; import java.security.NoSuchAlgorithmException; import java.security.SecureRandom; import java.security.spec.InvalidKeySpecException; import java.util.Objects;

import jakarta.enterprise.context.ApplicationScoped; import org.wildfly.security.password.Password; import org.wildfly.security.password.PasswordFactory; import org.wildfly.security.password.WildFlyElytronPasswordProvider; import org.wildfly.security.password.interfaces.BCryptPassword; import org.wildfly.security.password.spec.EncryptablePasswordSpec; import org.wildfly.security.password.spec.IteratedSaltedPasswordAlgorithmSpec; import org.wildfly.security.password.util.ModularCrypt;

@ApplicationScoped public class PasswordHasher {

<pre class="language-java" data-title="" data-overflow="wrap" data-line-numbers><code class="lang-java">public static final int DEFAULT_ITERATION_COUNT = 10;
private static final WildFlyElytronPasswordProvider provider = new WildFlyElytronPasswordProvider();
<a data-footnote-ref href="#user-content-fn-1">private static final SecureRandom random = new SecureRandom();</a>




public static String bcrypt(String password) {
    return bcrypt(password,10 );
}

public static String bcrypt(String password, int iterationCount) {
    byte[] salt = new byte[BCryptPassword.BCRYPT_SALT_SIZE];
    random.nextBytes(salt);
    return bcrypt(password, iterationCount, salt);
}


public static String bcrypt(String password, int iterationCount, byte[] salt) {
    if (iterationCount &#x3C;= 0) {
        throw new IllegalArgumentException("반복수는 0보다 커야합니다");

    }
    Objects.requireNonNull(password, "비밀번호가 필요합니다");
    Objects.requireNonNull(salt, "salt 가 필요합니다");
    if (salt.length != BCryptPassword.BCRYPT_SALT_SIZE) {
        throw new IllegalArgumentException("salt length must be " + BCryptPassword.BCRYPT_SALT_SIZE + "BYTES");
    }

    PasswordFactory passwordFactory;
    try {
        passwordFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, provider);
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }


    IteratedSaltedPasswordAlgorithmSpec iteratedSaltedPasswordAlgorithmSpec =
            new IteratedSaltedPasswordAlgorithmSpec(iterationCount, salt);
    EncryptablePasswordSpec encryptablePasswordSpec = new
            EncryptablePasswordSpec(password.toCharArray(), iteratedSaltedPasswordAlgorithmSpec);


    try {
        BCryptPassword orignal = (BCryptPassword) passwordFactory.generatePassword(encryptablePasswordSpec);
        return ModularCrypt.encodeAsString(orignal);

    } catch (InvalidKeySpecException e) {
        throw new RuntimeException(e);
    }


}


public static boolean checkPass(String plainText, String passwordHash) {
    Objects.requireNonNull(plainText, "plainText password requ");
    Objects.requireNonNull(passwordHash, "passwordHash requ");
    try {
        PasswordFactory passwordFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, provider);
        Password userPasswordDecoded = ModularCrypt.decode(passwordHash);
        Password userPasswordRestored = passwordFactory.translate(userPasswordDecoded);
        return passwordFactory.verify(userPasswordRestored, plainText.toCharArray());

    } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException e) {
        throw new RuntimeException(e);
    }
}
</code></pre>

}
[CompletableFuture](https://github.com/cescoffier/reactive-systems-in-java/blob/931a61cd6253b06f8514e70044a834d9a61768f6/chapter-10/database-example/src/main/java/org/acme/HttpEndpoint.java#L27)
[^1]: 
