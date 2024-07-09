# 완료 시점을 말할 수 없다면 시작하지 말아야 한다




>명제q를 연역적으로 증명 해보자
명제를 세운다 
논리적으로 증명(설명)한다
참인 명제->참인명제->참인...

공리(약속)나올때까지

수학적이론
집합론

>

> # 1.코드 손으로 직접 작성
> # 2.에디터에 옴긴 후 실행
> # 3.오류 발생 시 모르는 부분 확인 후 1번 으로





# Daily Goal

이슈 확인 하기~!



0518
## Upload jarx
<details>

```java
« Asynchronous Returns... | Main | Kafka vs. JMS/MQ--ai... »
Sending an InputStream to JAX-RS Resource
A JAX-RS resource accepting a plain InputStream:


@Path("uploads")
public class UploadsResource {

    @POST
    @Consumes("*/*")
    public void upload(InputStream stream) throws IOException {
        //consume input stream
        System.out.println("Read: " + stream.read());

    }    
}

...will consume any binary stream (e.g. file upload) of data as:

import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class UploadsResourceIT {

    private WebTarget tut;

    @Before
    public void init() {
        Client client = ClientBuilder.newClient();
        this.tut = client.target("http://localhost:8080/jaxrs-streaming/resources/uploads");
    }

    @Test
    public void sendStream() {
        InputStream stream = //...

        Response response = this.tut.
                request().
                post(Entity.entity(stream, MediaType.APPLICATION_OCTET_STREAM));
        assertThat(response.getStatus(), is(204));
    }    
}
The System Test is a Java SE client and therefore requires a JAX-RS API implementation (in our example: Apache CXF ):

<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-rt-rs-client</artifactId>
    <version>3.3.1</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-rt-rs-extension-providers</artifactId>
    <version>3.3.1</version>
    <scope>test</scope>
</dependency>  
</dependencies>         
Project created with javaee8-essentials-archetype, the 3kB ThinWAR was built and deployed with: wad.sh in 2329ms

See you at Web, MicroProfile and Java EE Workshops at Munich Airport, Terminal 2 or Virtual Dedicated Workshops / consulting. Is Munich's airport too far? Learn from home: airhacks.io.
Posted at 12:46PM Apr 19, 2019 by Adam Bien, Comments[0]  | Views/Hits: 2458
NEW live, virtual workshops: Persistence Patterns for Serverless Java on AWS, July, 11th, 2024 and Serverless Generative AI with Java on AWS, July, 18th are open for registration. Also via: meetup.com/airhacks
>500 Java Shorts Daily www.youtube.com/bienadam/shorts

airhacks.fm the podcast: 

You are invited to: airhacks discord server.

Stay in touch: airhacks.news.

COMMENTS:

POST A COMMENT:
Name:
 
E-Mail:
 
URL:
 
Notify me by email of new comments
 
Remember Information?
 
Your Comment:
HTML Syntax: NOT allowed
Please answer this simple math question

3 + 27 = 

 
```
 
</details>
# java 참고 서적
java precisely
java:the complete reference
이펙티브자바

ex()[ex_file.md]

# Windows Env 
### 에러나면 에러메세지 출려된 경로 먼저 확인해보자!

## kafka 실행 Script

> 카프카 위치 경로 확인 후 해당경로에 실행되도록 이동 또는 경로 지정 
> 주키퍼 카프카 순으로 실행
> bat->propertie 참조하니 설정 변경필요할시 해당 디렉토리 구성 수정 하면됨
```SHELL

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties  

.\bin\windows\kafka-server-start.bat .\config\server.properties

```

### 멀티파트 파일 업로드
<details>
 <summary> <h3> 멀티파트 파일 업로드 코드 참고  </h3> </summary> 


KimJohn Quinn님의 프로필 사진
KimJohn Quinn
읽지 않음,
2021. 7. 28. 오전 12:31:10
받는사람 Quarkus Development mailing list
Hello everyone.

First, our experience moving over to Quarkus has been absolutely spectacular!  Everything, including the docs, have been amazing and my only regret is not making the jump earlier.

I have run into an issue with the REST client, RESTEasy, and multipart payloads.

If I invoke the resource directly, through a test case or even curl, it seems to work fine.  Invoking any "client" methods  

The issues I am having are:
If I move the multipart payload to a different module (jar) I get this error in the resource "ClassNotFoundException: io.platform.api.publish.FilePackage_generated_populator"

The RESTClient will not generate the multipart signature/payload when the multipart signature is present.  Other methods/payloads work fine.  Here I get " Failed to generate client for class interface io.platform.api.publish.PublishClient : Unsupported multipart form field type: java.util.List<java.io.File> in field" yet I use the exact same class, with the resource, and it seems to work directly.

I am confused about the dependencies, we have standardized on a reactive approach and not sure what the interaction is between resteasy vs. mutiny vs. the Quarkus rest client, etc.  For a while I had issues with conflicting reactive vs. non-reactive when building.
The relevant code is:

Client Definition:  
```java
@POST
@Path("/{client}/package")
@Consumes(MULTIPART_FORM_DATA)
@Produces(APPLICATION_JSON)
@Operation(hidden = true)
Uni<Version> publish(@PathParam("client") final String client, @MultipartForm FilePackage request);

Client MultiPart Payload:
public class FilePackage {

    @FormParam("project")
    public String project;

    @FormParam("artifact")
    public String artifact;

    @FormParam("folder")
    public String folder;

    @FormParam("index")
    @PartType(APPLICATION_JSON)
    public Map<String, Integer> index;

    @FormParam("file")
    @PartType(APPLICATION_OCTET_STREAM)
    public List<File> files;

    public List<FileObject> getPackageFiles() { ... }
}
```

Resource Method (note PackageUpload is exactly the same as the FilePackage above - if i only use the simple parameters it marshals from the client to this resource fine - when I uncomment the files or index it fails - the reason I have two payloads, the same, is because of issue #1 above):
```java
@POST
@Path("/{client}/package")
@Consumes(MULTIPART_FORM_DATA)
@Produces(APPLICATION_JSON)
public Uni<Version> publishPackage(@MultipartForm final PackageUpload upload, @BeanParam final ClientRequest request) throws Exception { ... }

Client Test Cases:
@Inject
@RestClient
PublishClient publishClient;

This works using the client...
final JsonPackage pkg = testSupport.readJson(JsonPackage.class);
Version actual = publishClient.publish("my-client", pkg).await().indefinitely();
assertNotNull(actual);

I dont even get here with the client...
final FilePackage pkg = new FilePackage();
pkg.project = "my-project";
pkg.artifact = "my-artifact";
pkg.folder = "my-folder";
pkg.index = new HashMap<>();
pkg.files = new ArrayList<File>();

Version actual = publishClient.publish("my-client", pkg).await().indefinitely();
assertNotNull(actual);

This "resource" test looks to work (direct / no client)...
given().pathParam("client", "my-client")
        // Folder
        .formParam("project", "my-project")
        .formParam("artifact", "my-artifact")
        .formParam("folder", "my-folder")
        // Index
        .multiPart("index", index, APPLICATION_JSON)
        // Files
        .multiPart("file", file)
        .multiPart("file", file)
        .multiPart("file", file)
        .when()
        .post("/s3/publish/{client}/package")
        .then()
        .log().everything(true)
        .statusCode(OK.getStatusCode());
```

Maven Dependencies:
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-rest-client-reactive-jackson</artifactId>
 </dependency>
 <dependency>
     <groupId>io.quarkus</groupId>
     <artifactId>quarkus-resteasy-reactive-jackson</artifactId>
 </dependency>

</details>


-----------------------------------------------------------

<br/>
<br/>

## 카프카 이벤트 스트림 콘솔 테스팅
```
bin/windows/kafka-console-consumer.bat --topic wordcount-output --from-beginning --bootstrap-server localhost:9092  --property print.key=true

bin/windows/kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092

bin/windows/kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092

bin/windows/kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092

bin/windows/kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

```


