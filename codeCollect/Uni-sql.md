```java
package org.acme.extra;

import java.util.ArrayList;
import java.util.List;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

public class Fruit {

    public Long id;

    public String name;

    public Fruit() {
        // default constructor.
    }

    public Fruit(String name) {
        this.name = name;
    }

    public Fruit(Long id, String name) {
        this.id = id;
        this.name = name;
    }
//클라이언트 파라미터 전달 메서드
    public static Uni<List<Fruit>> findAll(PgPool client) {
        //클라이런트 호출
        return client
        //쿼리메소드 호출 쿼리문 파라미터 전달 
        .query("SELECT id, name FROM fruits ORDER BY name ASC")
        //실행 
        .execute()
        // 아이템 호출 함수  
        .onItem()
        // 폼전달   파라미터를 row셋으로  
        .transform(pgRowSet -> {
            //리스트 생성 과 리스트 사이즈 계산
                    List<Fruit> list = new ArrayList<>(pgRowSet.size());
                    //로우 셋 리스트 로우 만큼 반복을 add from row 반환 리스트 
                    for (Row row : pgRowSet) {
                        list.add(from(row));
                           return list;
                 }
             );
    }

    public static Uni<Fruit> findById(PgPool client, Long id) {
        return client.preparedQuery("SELECT id, name FROM fruits WHERE id = $1")
        .execute(Tuple.of(id))
                .onItem().transform(RowSet::iterator)
                .onItem().transform(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
    }

    public Uni<Long> save(PgPool client) {
        return client.preparedQuery("INSERT INTO fruits (name) VALUES ($1) RETURNING (id)").execute(Tuple.of(name))
                .onItem().transform(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
    }

    public Uni<Boolean> update(PgPool client) {
        return client.preparedQuery("UPDATE fruits SET name = $1 WHERE id = $2").execute(Tuple.of(name, id))
                .onItem().transform(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    public static Uni<Boolean> delete(PgPool client, Long id) {
        return client.preparedQuery("DELETE FROM fruits WHERE id = $1").execute(Tuple.of(id))
                .onItem().transform(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    private static Fruit from(Row row) {
        return new Fruit(row.getLong("id"), row.getString("name"));
    }
}
```

```java
package org.acme.extra;

import java.net.URI;

import jakarta.enterprise.event.Observes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;

@Path("fruits")
public class FruitResource {

    private final PgPool client;
    private final boolean schemaCreate;

    public FruitResource(PgPool client, @ConfigProperty(name = "myapp.schema.create", defaultValue = "true") boolean schemaCreate) {
        this.client = client;
        this.schemaCreate = schemaCreate;
    }

    void initdb(@Observes StartupEvent ev) {
        if (schemaCreate) {
            client.query("DROP TABLE IF EXISTS fruits").execute()
                    .flatMap(r -> client.query("CREATE TABLE fruits (id SERIAL PRIMARY KEY, name TEXT NOT NULL)")
                            .execute())
                    .flatMap(r -> client.query("INSERT INTO fruits (name) VALUES ('Orange')").execute())
                    .flatMap(r -> client.query("INSERT INTO fruits (name) VALUES ('Pear')").execute())
                    .flatMap(r -> client.query("INSERT INTO fruits (name) VALUES ('Apple')").execute())
                    .await().indefinitely();
        }
    }

    @GET
    public Uni<Response> get() {
        return Fruit.findAll(client)
                .onItem().transform(Response::ok)
                .onItem().transform(ResponseBuilder::build);
    }

    @GET
    @Path("{id}")
    public Uni<Response> getSingle(Long id) {
        return Fruit.findById(client, id)
                .onItem().transform(fruit -> fruit != null ? Response.ok(fruit) : Response.status(Status.NOT_FOUND))
                .onItem().transform(ResponseBuilder::build);
    }

    @POST
    public Uni<Response> create(Fruit fruit) {
        return fruit.save(client)
                .onItem().transform(id -> URI.create("/fruits/" + id))
                .onItem().transform(uri -> Response.created(uri).build());
    }

    @PUT
    @Path("{id}")
    public Uni<Response> update(Long id, Fruit fruit) {
        return fruit.update(client)
                .onItem().transform(updated -> updated ? Status.OK : Status.NOT_FOUND)
                .onItem().transform(status -> Response.status(status).build());
    }

    @DELETE
    @Path("{id}")
    public Uni<Response> delete(Long id) {
        return Fruit.delete(client, id)
                .onItem().transform(deleted -> deleted ? Status.NO_CONTENT : Status.NOT_FOUND)
                .onItem().transform(status -> Response.status(status).build());
    }
}
```
