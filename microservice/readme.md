
## krakend api gateway explain
> https://youtu.be/ni-rti5DgYY?si=XMm-Z-XKVnBGPBEQ




rest HTTP 예제
> https://quarkus.io/guides/rest-client

api 요청 헤더 패턴 정리
```java

@Path("/extensions")
@RegisterRestClient
@RegisterClientHeaders(RequestUUIDHeaderFactory.class) 
@ClientHeaderParam(name = "my-header", value = "constant-header-value") 
@ClientHeaderParam(name = "computed-header", value = "{org.acme.rest.client.Util.computeHeader}") 
public interface ExtensionsService {

    @GET
    @ClientHeaderParam(name = "header-from-properties", value = "${header.value}") 
    @ClientHeaderParam(name = "header-from-method-param", value = "Bearer {token}") 
    Set<Extension> getById(@QueryParam("id") String id, @HeaderParam("jaxrs-style-header") String headerValue, @NotBody String token); 
}

```

```java
 @Override
    public Uni<MultivaluedMap<String, String>> getHeaders(
            MultivaluedMap<String, String> incomingHeaders,
            MultivaluedMap<String, String> clientOutgoingHeaders) {
        return Uni.createFrom().item(() -> {
            MultivaluedHashMap<String, String> newHeaders = new MultivaluedHashMap<>();
            // perform blocking call
            newHeaders.add(HEADER_NAME, service.getToken());
            return newHeaders;
        });
    }

```



> HTTP 기본 인증을 사용할 때 @io.quarkus.rest.client.reactive.ClientBasicAuth주석은 필요한 Authorization헤더를 구성하는 훨씬 간단한 방법을 제공합니다.


```java


@ClientBasicAuth(username = "${service.username}", password = "${service.password}")
public interface SomeClient {

}

```

# 사용자 정의 요청 필터
> REST 클라이언트는 필터를 통해 서버로 전송되는 최종 요청의 추가 사용자 정의를 지원합니다. 필터는 인터페이스 ClientRequestFilter또는 ResteasyReactiveClientRequestFilter.
사용자 정의하는 요청의 예는 사용자 정의 헤더를 추가하는 것입니다.



```java

//사용자 정의 요청 헤더를 추가
@Provider
public class TestClientRequestFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) {
        requestContext.getHeaders().add("my_header", "value");
    }
}

//다음으로 주석을 사용하여 필터를 등록할 수 있습니다 @RegisterProvider.
@Path("/extensions")
@RegisterProvider(TestClientRequestFilter.class)
public interface ExtensionsService {

    // ...
}



//또는 프로그래밍 방식으로 다음 .register()메서드를 사용합니다.
QuarkusRestClientBuilder.newBuilder()
    .register(TestClientRequestFilter.class)
    .build(ExtensionsService.class)


```



















