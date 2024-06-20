```java
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    @Roles({"USER"})
    public String username;

    @Password
    public String password;

    // Getters, setters, and other methods
}
```

Next, let's define the REST API for user registration:

```java
import io.quarkus.panache.common.Parameters;
import io.quarkus.rest.security.AnonymousAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/register")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegistrationResource {

    @Inject
    UserRepository userRepository;

    @POST
    @Transactional
    public Response registerUser(RegisterRequest request) {
        // Check if the user already exists
        User existingUser = userRepository.find("username = :username", Parameters.with("username",
request.username)).firstResult();
        if (existingUser != null) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        // Hash the password before saving
        request.password = SecurityUtil.hashPassword(request.password);

        User user = new User();
        user.username = request.username;
        user.setPassword(request.password);
        user.persistAndFlush();

        return Response.ok().build();
    }
}
```

In this example, we're using a `UserRepository` to interact with the User entity and handling password hashing in
a separate utility class:

```java
import org.jboss.logging.Logger;
import javax.inject.Singleton;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;

@Singleton
public class SecurityUtil {
    private static final Logger LOG = Logger.getLogger(SecurityUtil.class);
    private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 5000;
    private static final int KEY_LENGTH = 256;

    public static String hashPassword(String password) {
        // Generate a random salt
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);

        try {
            // Hash the password with the generated salt
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = skf.generateSecret(spec).getEncoded();

            // Encode the salt and hashed password as a single base64 string
            return Base64.getEncoder().encodeToString(salt) + "$" + Base64.getEncoder().encodeToString(hash);
        } catch (Exception ex) {
            LOG.error("Failed to hash password", ex);
            throw new RuntimeException("Failed to hash password");
        }
    }
}
```
