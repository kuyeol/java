 Quarkus, a popular Java framework for building cloud-native applications,
provides built-in support for creating API gateways that can be used for 
microservice discovery. Here are the steps to create a simple REST gateway
using Quarkus:

1. Create a new Quarkus application with the `quarkus-resteasy` and 
`quarkus-smallrye-openapi` extensions, which provide support for building 
REST APIs and generating OpenAPI documentation respectively. You can 
create a new project by running the following command in your terminal:
```lua
mvn io.quarkus:quarkus-maven-plugin:2.3.1.Final:create \
 -DprojectGroupId=com.example \
 -DprojectArtifactId=quarkus-rest-gateway \
 -DclassName="com.example.QuarkusRestGateway" \
 -Dextensions="resteasy, smallrye-openapi"
```
2. Define the microservices that your gateway will discover and proxy to. 
In this example, we'll define two microservices: `microservice-a` and 
`microservice-b`. Each microservice should have its own REST endpoint 
(e.g., `/ms-a` and `/ms-b`).
3. Configure your gateway to discover the microservices using either DNS 
or service discovery. In this example, we'll use DNS discovery by defining
two `RouteLocatorBuilder` instances for each microservice:
```java
@ApplicationScoped
public class RouteConfig {

    @Inject
    RouterAdmin admin;

    public void configureRoutes() {
        RouteLocatorBuilder locatorBuilder = admin.routes();

        // Define the route for microservice-a
        LocatorRouteBuilder msA = locatorBuilder.route("ms-a")
                .path("/ms-a/*")
                .filters(f -> f.addRequestHeader("destination", 
"microservice-a"))
                .uri("http://microservice-a:8080");

        // Define the route for microservice-b
        LocatorRouteBuilder msB = locatorBuilder.route("ms-b")
                .path("/ms-b/*")
                .filters(f -> f.addRequestHeader("destination", 
"microservice-b"))
                .uri("http://microservice-b:8080");

        // Register the routes with the gateway
        admin.routes().register(msA.build(), msB.build());
    }
}
```
This code defines two `LocatorRouteBuilder` instances for each 
microservice, which specify the path, filters (e.g., adding a request 
header), and URI for each service. The `addRequestHeader` filter is used 
to add a custom header that can be used by the downstream microservices to
identify the source of the request.

4. Define a simple REST endpoint that proxies requests to the discovered 
microservices:
```java
@Path("/")
public class GreetingResource {

    @Inject
    RouterAdmin admin;

    @GET
    @Path("/{service}/greetings/{name}")
    public Response greetings(@PathParam("service") String service, 
@PathParam("name") String name) {
        LocatorRouteBuilder locatorBuilder = admin.routes();
        LocatorRoute route = 
locatorBuilder.route(service).path("/greetings/{name}").build();

        Request request = Request.newBuilder()
                .uri(URI.create(route.getUri().toString()))
                .header("destination", service)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to send request", e);
        }

        return Response.ok().entity(response.body()).build();
    }
}
```
This code defines a simple REST endpoint that takes two path parameters: 
`service` and `name`. The `service` parameter is used to identify which 
microservice to proxy the request to, while the `name` parameter is passed
as a query parameter to the downstream microservice.

The `LocatorRouteBuilder` instance is used to build a route for the 
specified service, which includes the path and URI for the microservice. 
The `Request` object is then constructed with the appropriate headers and 
method, and sent to the downstream microservice using the `HttpClient` 
instance.

5. Test your gateway by sending requests to the REST endpoint defined in 
step 4:
```bash
$ curl http://localhost:8080/ms-a/greetings/world
Hello, world from microservice-a!

$ curl http://localhost:8080/ms-b/greetings/world
Hello, world from microservice-b!
```
These requests should be proxied to the appropriate microservices and 
return a response with the custom greeting.
