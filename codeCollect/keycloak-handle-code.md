



```java

package com.yourcompany.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class KeycloakAdminConfig {

    @Produces
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080/auth")
                .realm("master")
                .clientId("admin-cli")
                .clientSecret("your-client-secret")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .username("admin")
                .password("admin-password")
                .build();
    }
}

```

```java
package com.yourcompany.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Collections;

@ApplicationScoped
public class UserService {

    @Inject
    Keycloak keycloak;

    private static final String REALM = "your-realm";

    public String createUser(String username, String email, String firstName, String lastName, String password) {
        RealmResource realmResource = keycloak.realm(REALM);
        
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEnabled(true);

        Response response = realmResource.users().create(user);
        if (response.getStatus() == 201) {
            String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");

            CredentialRepresentation credential = new CredentialRepresentation();
            credential.setTemporary(false);
            credential.setType(CredentialRepresentation.PASSWORD);
            credential.setValue(password);
            
            realmResource.users().get(userId).resetPassword(credential);
            
            return userId;
        } else {
            throw new RuntimeException("Failed to create user: " + response.getStatus());
        }
    }
}
```


```java
package com.yourcompany.controller;

import com.yourcompany.service.UserService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public String createUser(CreateUserRequest request) {
        return userService.createUser(request.getUsername(), request.getEmail(), request.getFirstName(), request.getLastName(), request.getPassword());
    }
}

class CreateUserRequest {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    // Getters and Setters
}
```


### 5. 애플리케이션 실행 및 테스트

Quarkus 애플리케이션을 실행하고, 유저 생성 API를 테스트합니다. 예를 들어, Postman을 사용하여 다음과 같이 요청을 보낼 수 있습니다:

```json
POST http://localhost:8080/users
Content-Type: application/json

{
    "username": "newuser",
    "email": "newuser@example.com",
    "firstName": "New",
    "lastName": "User",
    "password": "password123"
}
```
