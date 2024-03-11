java programming fundumetal
Java is a statically typed, object-oriented,
class-based language that's designed for the
internet. Here are some key concepts and
terminologies in Java:

1. **Class**: A blueprint or prototype from which
objects are created. It represents set of properties
(known as attributes) and behaviors (known as
methods).

2. **Object**: An instance of a class that has state
and behavior.

3. **Inheritance**: The mechanism in Java by which
one class is allowed to inherit the features (fields)
and functionality (methods) of another.

4. **Polymorphism**: Ability of an object to take on
many forms. It can refer to subclasses of a class
with specific meaning.

5. **Abstraction**: Hiding complex details and
showing only essential information to the user. In
Java, it's achieved through abstract classes and
interfaces.

6. **Encapsulation**: Wrapping up of data under a
single unit. It can be used to hide the values or
state of structured data.

7. **Package**: A namespace that organizes a set of
related classes and interfaces.

8. **Interface**: A reference type, similar to a
class, that can contain only constants, method
signatures, default methods, static methods, and
nested types.

9. **Exception Handling**: Mechanism to handle
runtime errors so that normal flow of the application
can be maintained.

Here's an example with each concept:

```java
// Class Definition
public class Bicycle {
    // Instance Variables (state)
    private int cadence;
    private int gear;
    private int speed;

    // Constructor
    public Bicycle(int startCadence, int startSpeed,
int startGear) {
        this.cadence = startCadence;
        this.speed = startSpeed;
        this.gear = startGear;
    }

    // Method (behavior)
    public void setCadence(int newValue) {
        cadence = newValue;
    }
}

// Inheritance Example
public class MountainBike extends Bicycle {
    private String suspension;

    public MountainBike(int startHeight, int
startCadence, int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
// Calling parent constructor
        this.setSuspension(suspension);
    }

    public void setSuspension(String suspensionType){
        this.suspension = suspensionType;
    }
}

// Polymorphism Example
Bicycle bike1 = new MountainBike(5, 20, 30, 4); //
MountainBike is a Bicycle

// Abstraction Example (abstract class)
public abstract class Graphic {
    protected int x;
    protected int y;

    public abstract void draw(); // Abstract method
}

// Encapsulation Example
public class Person {
   private String name;

   public String getName() {
      return this.name;
   }

   public void setName(String newName) {
      this.name = newName;
   }
}
```
Remember that Java is a statically-typed language,
meaning all variables must have a type defined and it
doesn't support automatic type inference like Python
or JavaScript do.


>>> quarkus zanzibar code example
Zanzibar is an authorization system used for managing
access to resources in distributed systems. In the
context of Quarkus, Zanzibar can be utilized to
manage role-based access control (RBAC).

However, please note that it's currently not possible
to use Zanzibar directly with Quarkus as it is a
standalone project and isn't integrated with Quarkus.
You need to configure the necessary roles for each
endpoint manually in your application.

Here's an example of how you could do role-based
authorization using Quarkus:

1. Define roles:
```java
public enum Role {
    ADMIN, USER
}
```

2. Annotate methods with the `@RolesAllowed`
annotation to specify what roles can access a
particular endpoint:

```java
import javax.annotation.security.RolesAllowed;
//...

public class MyResource {
    @GET
    @Path("/admin")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("ADMIN") // Only users with the
ADMIN role can access this endpoint
    public String adminOnly() {
        return "Admin only";
    }
}
```
3. In your application properties, define which roles
have access to each endpoint:

```properties
quarkus.http.auth.permission.roles-path=/admin
quarkus.http.auth.permission.authenticated=true
quarkus.http.auth.permission.permit-all=false
quarkus.http.auth.permission."/admin".roles=ADMIN
```
In this example, only users with the ADMIN role can
access the `/admin` endpoint.

Please note that in a real application, you would
likely need to implement some sort of authentication
system (like JWT) and user management service, which
is beyond the scope of this simple example.

For more information on how to configure security
with Quarkus, please refer to the [Quarkus Security
Guide](https://quarkus.io/guides/security).