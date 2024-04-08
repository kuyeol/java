
> [!note]
> <details>
> <summary> 레퍼런스 링크 모음 </summary>
>  
> ### [CDI 자카르타 사양 레퍼런스 링크](https://jakarta.ee/specifications/cdi/2.0/cdi-spec-2.0.html)
>
> ### [QUARKUS 레퍼런스](https://quarkus.io/guides/cdi-reference)
> 
> </details>



---
# 내용 요약
> [!TIP]
> 간단한 참고 사항

<details>

<summary>데이터 엑세스 Logger 클래스</summary>

---

```java
@Produces
Logger createLogger(InjectionPoint injectionPoint)
{
    return Logger.getLogger( injectionPoint.getMember().getDeclaringClass().getName() );
}
```

</details>


<details>

<summary>데이터 엑세스 Logger 클래스</summary>

---

```java
@Produces
Logger createLogger(InjectionPoint injectionPoint)
{
    return Logger.getLogger( injectionPoint.getMember().getDeclaringClass().getName() );
}
```

</details>

---
