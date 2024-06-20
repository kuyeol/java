```java
//usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS io.smallrye.reactive:smallrye-mutiny-vertx-web-client:1.1.0
//DEPS io.smallrye.reactive:mutiny:0.7.0
//DEPS org.slf4j:slf4j-nop:1.7.30

package io.vertx.mutiny.pagination;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.core.buffer.Buffer;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import io.vertx.mutiny.ext.web.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Pagination {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        WebClient client = WebClient.create(vertx, new WebClientOptions()
                .setDefaultHost("api.punkapi.com")
                .setDefaultPort(443)
                .setSsl(true)
        );

        Multi<Beer> multi = Multi.createBy().repeating().uni(AtomicInteger::new, page ->
                getPage(client, page.incrementAndGet())
        )
                .until(List::isEmpty)
                .onItem().disjoint();

        List<Beer> ipa = multi
                .transform().byFilteringItemsWith(beer -> beer.description.contains("IPA"))
                .transform().byTakingFirstItems(10)

                .collectItems().asList()
                .await().indefinitely();

        System.out.println(ipa);
        vertx.closeAndAwait();

    }

    private static Uni<List<Beer>> getPage(WebClient client, int page) {
        System.out.println("Retrieving page: " + page);
        return client.get("/v2/beers?page=" + page)
                .send()
                .onItem().transform(Pagination::toListOfBeer);
    }

    private static List<Beer> toListOfBeer(HttpResponse<Buffer> response) {
        if (response.statusCode() != 200) {
            return Collections.emptyList();
        }

        return response.bodyAsJsonArray().stream()
                .map(o -> (JsonObject) o)
                .map(json -> new Beer(json.getString("name"), json.getDouble("abv"), json.getString("description")))
                .collect(Collectors.toList());
    }

    private static class Beer {
        public final String name;
        public final double alcohol;
        public final String description;

        private Beer(String name, double alcohol, String description) {
            this.name = name;
            this.alcohol = alcohol;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Beer{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}

```


```java
package guides.operators;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.AssertSubscriber;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class PaginationTest {

    @SuppressWarnings("Convert2MethodRef")
    @Test
    public void test() {
        // <code>
        PaginatedApi api = new PaginatedApi();

        Multi<String> stream = Multi.createBy().repeating()
                .completionStage(
                        () -> new AtomicInteger(),
                        state -> api.getPage(state.getAndIncrement()))
                .until(list -> list.isEmpty())
                .onItem().disjoint();
        // </code>
        stream.subscribe().withSubscriber(AssertSubscriber.create(10))
                .assertCompleted()
                .assertItems("a", "b", "c", "d", "e", "f", "g", "h");

    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    public void test2() {
        // <code2>
        PaginatedApi api = new PaginatedApi();

        Multi<Page> stream = Multi.createBy().repeating()
                .uni(
                        () -> new AtomicInteger(),
                        state -> api.retrieve(state.getAndIncrement()))
                .whilst(page -> page.hasNext());
        // </code2>
        AssertSubscriber<Page> subscriber = stream.subscribe()
                .withSubscriber(AssertSubscriber.create(10))
                .assertCompleted();

        assertThat(subscriber.getItems()).hasSize(3);

    }

    private static class Page {
        final boolean hasNext;

        private Page(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public boolean hasNext() {
            return hasNext;
        }
    }


    private class PaginatedApi {

        Map<Integer, List<String>> pages = new LinkedHashMap<>();

        public PaginatedApi() {
            pages.put(0, Arrays.asList("a", "b", "c"));
            pages.put(1, Arrays.asList("d", "e", "f"));
            pages.put(2, Arrays.asList("g", "h"));
            pages.put(3, Collections.emptyList());
        }

        CompletionStage<List<String>> getPage(int page) {
            List<String> strings = pages.get(page);
            if (strings == null) {
                strings = Collections.emptyList();
            }
            return CompletableFuture.completedFuture(strings);
        }


        Uni<Page> retrieve(int page) {
            if (page == 2) {
                return Uni.createFrom().item(new Page(false));
            }
            return Uni.createFrom().item(new Page(true));
        }
    }

}
```
