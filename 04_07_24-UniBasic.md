# 객체 매핑

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
    //static 클래스로 불러오도록 파이널로 수정 방지
    static class TemperatureRecord {
        final Country country;
        final String city;
        final long timestamp;
        final double value;

//생성자 선언 해당 클래스를 참조 할수 있도록 타입으로 사용한다
//참조 타입선언 [ class, array, interface, Enumeration ]  
        TemperatureRecord(Country country, String city, long timestamp, double value) {
            this.country = country;
            this.city = city;
            this.timestamp = timestamp;
            this.value = value;
        }
//객체 값을 문자열로 표현하여 읽을 수 있도록한다
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
//컨트리 클래스의 상수 정의
    enum Country {
        FRANCE,
        UK,
        AUSTRALI

    }

    public static void main(String[] args) {
        System.out.println("⚡️ Multi split operator");
//임의 데이터 로드
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
//스플리터 정의 = createfrom data spilt contryclass -> conutry (split data )
        var splitter = Multi.createFrom().iterable(data)
                .split(Country.class, record -> record.country);
//스플리메서드 사용 컨트리 클래스 상수프랑스 구독 에외 처리와 완료시 메세지 출력 .with 내부 프린트에서 record가 출력하는 내용은 get에서 구독한 객체를 iterable(data) 반복하여 출력
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




# 블로킹

```JAVA
///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:2.6.0
package _06_threading;

import java.util.stream.Collectors;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.BlockingIterable;

public class _04_Threading_Blocking {

    public static void main(String[] args) {
        System.out.println("⚡️ blocking");

        BlockingIterable<Integer> iterable = Multi.createFrom().range(0, 10)
                .subscribe().asIterable();

        var list = iterable.stream().collect(Collectors.toList());

        System.out.println(list);

        Integer someInt = Uni.createFrom().item(123)
                .await().indefinitely();

        System.out.println(someInt);
    }
}
```



