> 객체 매핑

```java

    public static void main(String[] args) {



        //아이템 변수 89.on아이템 트랜스폼 n이라고 하고 -> n*12 on아이템 트랜스폼 오브젝트 tostring subscribejkjlj

        Uni.createFrom().item(123)
                //q변수 n을 외부 메서드에서 참조하여 매핑 매개변수 명은 동일해야함
                .onItem().transformToUni(n -> increase(n))
                //가져온 매개변수를 이용해 값을 변환 스트링으로 사용되어 연산은 되지않고 문자열로 취급
                .onItem().transformToUni((b, emitter) -> emitter.complete("[" + b+","+1 + "]"))
                .subscribe().with(System.out::println);





    }
    static Uni<Integer> increase(int n){

        return Uni.createFrom().item(n * 10);
    }

}

```

# 아이템 구독 메서드
```JAVA

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Main {


    public static void main(String[] args) {
        //구독아이템 생성 uni
        Uni<String> uni =
                Uni.createFrom().item("17:생성된아이템\n").onItem().transform(n->n+"17-2:아이템");
        //
        uni.subscribe().withSubscriber(new UniSubscriber<String>() {





            @Override
            public void onSubscribe(UniSubscription uniSubscription) {
                System.out.println("23:구독메서드\n");
            }

            @Override
            public void onItem(String item) {
                System.out.println("28:온아이템 메서드/" + "28:호출 아이템:"+item);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("fail" + throwable.getMessage());
            }
        });

    }

}
```


# 멀티 구독 

```JAVA

import java.util.List;
import static org.example.Main.Country.*;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;
import java.util.Random;

import static java.util.concurrent.CompletableFuture.delayedExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    static class TemperatureRecord {
        final Country country;
        final String city;
        final long timestamp;
        final double value;

        TemperatureRecord(Country country, String city, long timestamp, double value) {
            this.country = country;
            this.city = city;
            this.timestamp = timestamp;
            this.value = value;
        }

        @Override
        public String toString() {
            return "TemperatureRecord{" +
                    "country=" + country +
                    ", city='" + city + '\'' +
                    ", timestamp=" + timestamp +
                    ", value=" + value +
                    '}';
        }
    }

    enum Country {
        FRANCE,
        UK,
        AUSTRALIA

    }

    public static void main(String[] args) {
        System.out.println("⚡️ Multi split operator");

        var data = List.of(
                new TemperatureRecord(FRANCE, "Tassin-La-Demi-Lune", System.nanoTime(), 28.0),
                new TemperatureRecord(FRANCE, "Clermont-Ferrand", System.nanoTime(), 27.0),
                new TemperatureRecord(FRANCE, "Nevers", System.nanoTime(), 27.0),
                new TemperatureRecord(FRANCE, "Aubière", System.nanoTime(), 28.0),
                new TemperatureRecord(AUSTRALIA, "Sydney", System.nanoTime(), 16.0),
                new TemperatureRecord(FRANCE, "Lyon", System.nanoTime(), 29.0),
                new TemperatureRecord(AUSTRALIA, "Kensington", System.nanoTime(), 16.0),
                new TemperatureRecord(UK, "Newcastle", System.nanoTime(), 13.0),
                new TemperatureRecord(AUSTRALIA, "Coogee", System.nanoTime(), 16.0),
                new TemperatureRecord(UK, "Bexhill", System.nanoTime(), 22.0));

        var splitter = Multi.createFrom().iterable(data)
                .split(Country.class, record -> record.country);

        splitter.get(FRANCE)
                .subscribe().with(
                        record -> System.out.println("🇫🇷 => " + record),
                        Throwable::printStackTrace,
                        () -> System.out.println("✅ Done with France"));

        splitter.get(AUSTRALIA)
                .subscribe().with(
                        record -> System.out.println("🇦🇺🦘 => " + record),
                        Throwable::printStackTrace,
                        () -> System.out.println("✅ Done with Australia"));

        splitter.get(UK)
                .subscribe().with(
                        record -> System.out.println("🇬🇧 => " + record),
                        Throwable::printStackTrace,
                        () -> System.out.println("✅ Done with the UK"));
    }
}
```










