# 유저서비스 개발

## 클래스 extends 클래스

{% hint style="info" %}
extends 사용 시 기존 구현  내용은 제외하고 추가 필드만 작성하여 사용이 가능하다

기존 필드는 상속되어 호출
{% endhint %}

{% tabs %}
{% tab title="커스텀 extends 클래스" %}
기존 인증 엔터티  클래스에서  Athenticator에 구현된   password 필드가 없어

확장하여 작성 해보았다



<pre class="language-java" data-title="" data-overflow="wrap" data-line-numbers><code class="lang-java">package org.acme.security.webauthn;

<strong>import io.vertx.ext.auth.webauthn.Authenticator;
</strong>
<strong>public class MyAuthenticator extends Authenticator {
</strong>
<strong>    public String password;
</strong><strong>
</strong><strong>    public String getPassword() {
</strong><strong>        return password;
</strong><strong>    }
</strong>
<strong>    public void setPassword(String password) {
</strong><strong>        this.password = password;
</strong><strong>    }
</strong>
}
</code></pre>
{% endtab %}

{% tab title="기존 인증 엔터티" %}
Authenticator에 password필드가 없어 매핑 불가하여 코드를 추가 해보려고 시도

{% code title="" overflow="wrap" lineNumbers="true" %}
```java
package org.acme.security.webauthn;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.vertx.ext.auth.webauthn.Authenticator;
import io.vertx.ext.auth.webauthn.PublicKeyCredential;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userName", "credID"}))
@Entity
public class WebAuthnCredential extends PanacheEntity {

    /**
     * The username linked to this authenticator
     */
    public String userName;

    /**
     * The type of key (must be "public-key")
     */
    public String type = "public-key";

    /**
     * The non user identifiable id for the authenticator
     */
    public String credID;

    /**
     * The public key associated with this authenticator
     */
    public String publicKey;

    /**
     * The signature counter of the authenticator to prevent replay attacks
     */
    public long counter;

    public String aaguid;

    /**
     * The Authenticator attestation certificates object, a JSON like:
     * <pre>{@code
     *   {
     *     "alg": "string",
     *     "x5c": [
     *       "base64"
     *     ]
     *   }
     * }</pre>
     */
    /**
     * The algorithm used for the public credential
     */
    public PublicKeyCredential alg;

    /**
     * The list of X509 certificates encoded as base64url.
     */
    @OneToMany(mappedBy = "webAuthnCredential")
    public List<WebAuthnCertificate> x5c = new ArrayList<>();

    public String fmt;

    // owning side
    @OneToOne
    public User user;

    public WebAuthnCredential() {
    }

    public WebAuthnCredential(Authenticator authenticator, User user) {
        aaguid = authenticator.getAaguid();
        if(authenticator.getAttestationCertificates() != null)
            alg = authenticator.getAttestationCertificates().getAlg();
        counter = authenticator.getCounter();
        credID = authenticator.getCredID();
        fmt = authenticator.getFmt();
        publicKey = authenticator.getPublicKey();
        type = authenticator.getType();
        userName = authenticator.getUserName();
        if(authenticator.getAttestationCertificates() != null
                && authenticator.getAttestationCertificates().getX5c() != null) {
            for (String x5c : authenticator.getAttestationCertificates().getX5c()) {
                WebAuthnCertificate cert = new WebAuthnCertificate();
                cert.x5c = x5c;
                cert.webAuthnCredential = this;
                this.x5c.add(cert);
            }
        }
        this.user = user;
        user.webAuthnCredential = this;
    }

    public static List<WebAuthnCredential> findByUserName(String userName) {
        return list("userName", userName);
    }

    public static List<WebAuthnCredential> findByCredID(String credID) {
        return list("credID", credID);
    }
}
}
```
{% endcode %}
{% endtab %}

{% tab title="커스텀 인증 엔터티" %}
Authenticator 를 확장하여&#x20;

password 를   추가해봄

{% code title="" overflow="wrap" lineNumbers="true" %}
```java
package org.acme.security.webauthn;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import io.vertx.ext.auth.webauthn.PublicKeyCredential;

@Entity
public class WebAuthCred extends PanacheEntity {


    public String password;
   
     @OneToOne
    public User user;

    public String fmt;

    public WebAuthCred(){}

    public WebAuthCred(MyAuthenticator myAuthenticator,User user){
        password=myAuthenticator.getPassword();
        fmt=myAuthenticator.getFmt();
    }


}
```
{% endcode %}
{% endtab %}
{% endtabs %}
