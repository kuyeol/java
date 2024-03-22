# algo
<a href="https://github.com/GitbookIO/gitbook/blob/master/docs/{{ file.path }}" target="_blank" class="btn btn-link pull-right hidden-xs">
    <i class="octicon octicon-mark-github"></i> Edit on GitHub
</a>

```java

static final Provider ELYTRON_PROVIDER = new WildFlyElytronProvider();
static final String TEST_PASSWORD = "test_password";

public static void main(String[] args) throws Exception {
    PasswordFactory passwordFactory = PasswordFactory.getInstance(SaltedSimpleDigestPassword.ALGORITHM_PASSWORD_SALT_DIGEST_SHA_512, ELYTRON_PROVIDER);

    byte[] salt = new byte[32];
    SecureRandom random = new SecureRandom();
    random.nextBytes(salt);

    SaltedPasswordAlgorithmSpec saltedSpec = new SaltedPasswordAlgorithmSpec(salt);
    EncryptablePasswordSpec encryptableSpec = new EncryptablePasswordSpec(TEST_PASSWORD.toCharArray(), saltedSpec);

    SaltedSimpleDigestPassword original = (SaltedSimpleDigestPassword) passwordFactory.generatePassword(encryptableSpec);

    byte[] digest = original.getDigest();

    SaltedHashPasswordSpec saltedHashSpec = new SaltedHashPasswordSpec(digest, salt);

    SaltedSimpleDigestPassword restored = (SaltedSimpleDigestPassword) passwordFactory.generatePassword(saltedHashSpec);

    System.out.println(String.format("Password Verified '%b'", passwordFactory.verify(restored, TEST_PASSWORD.toCharArray())));
}


```

```java
@ApplicationScoped
public class AccountService {

    @Autowired
    private Argon2Service argon2Service;

    public String hashPassword(String password) {
        return argon2Service.hash(password);
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return argon2Service.verify(password, hashedPassword);
    }
}
```

3. Modify your `User` entity to include the hashed password:

```java
@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String username;

    private String email;

    private String hashedPassword;

    // Getters and setters omitted for brevity
}
```

4. Modify your `UserController` to use the `AccountService` for password hashing and verification:

````java
@RestController
@Path("users")
public class UserController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Validate the user input
        if (user.getUsername() == null || user.getEmail() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Hash the password using the AccountService
        user.setHashedPassword(accountService.hashPassword(user.getPassword()));

        // Save the user to the database
        User savedUser = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        // Validate the user input
        if (user.getUsername() == null || user.getEmail() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Find the existing user by ID
        User existingUser = userRepository.findById(id).orElseThrow(() -> new
ResponseStatusException(HttpStatus.NOT_FOUND));

        // Update the user's password (if provided) using the AccountService
        if (user.getPassword() != null) {
            existingUser.setHashedPassword(accountService.hashPassword(user.getPassword()));
        }

        // Save the updated user to the database
        User savedUser = userRepository.save(existingUser);

        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        // Find the existing user by ID
        User existingUser = userRepository.findById(id).orElseThrow(() -> new
ResponseStatusException(HttpStatus.NOT_FOUND));

        // Remove the user from the database
        userRepository.delete(existingUser);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
```java
5. Finally, you can use the `AccountService` to handle password hashing and verification in your Quarkus
application. For example, you could use it to hash and verify the password when a user logs in or creates an
account:
````

@RestController @Path("login") public class LoginController {

```
@Autowired
private AccountService accountService;

@PostMapping
public ResponseEntity<User> login(@RequestBody User user) {
    // Validate the user input
    if (user.getUsername() == null || user.getPassword() == null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    // Hash the password using the AccountService
    user.setHashedPassword(accountService.hashPassword(user.getPassword()));

    // Find the user in the database by username and password
    User foundUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getHashedPassword());

    // If the user is found, return the user object
    if (foundUser != null) {
        return ResponseEntity.status(HttpStatus.OK).body(foundUser);
    }

    // Otherwise, return an error response
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
}
```

}

```
```
