# java

\[TOC]

## Chapter 1 microservice

### 1 account

[Source Path](https://c/Users/ung-Z13/Downloads/manning-kube-native-microservices-master/manning-kube-native-microservices-master/accountRest)

### 2 account1

<pre class="language-java" data-title="test.java" data-overflow="wrap" data-line-numbers><code class="lang-java">    
    
    
    
<strong>    public static String bcrypt(String password, int iterationCount, byte[] salt) {
</strong>        if (iterationCount &#x3C;= 0) {
            throw new IllegalArgumentException("반복수는 0보다 커야합니다");

<strong>        }
</strong>        Objects.requireNonNull(password, "비밀번호가 필요합니다");
<strong>        Objects.requireNonNull(salt, "salt 가 필요합니다");
</strong>        if (salt.length != BCryptPassword.BCRYPT_SALT_SIZE) {
<strong>            throw new IllegalArgumentException("salt length must be " + BCryptPassword.BCRYPT_SALT_SIZE + "BYTES");
</strong>        }

        PasswordFactory passwordFactory;
        try {
            passwordFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, provider);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

</code></pre>

[Source Path](https://c/Users/ung-Z13/Downloads/manning-kube-native-microservices-master/manning-kube-native-microservices-master/accountRest/src/main/java/org/acme/reactive/crud/security/PasswordHasher.java)

## Chapter 2 Basic

### 1 extends 클래스

```java
public class MyAuthenticator extends Authenticator {

    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

```

[Source Path](https://d/IDEA/security-webauthn-quickstart/src/main/java/org/acme/security/webauthn/MyAuthenticator.java)
