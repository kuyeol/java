# Transactional
>Panache 엔터티 메서드 사용과 반응형 범위 호출
> 리액티브 방식의 코드 사용ㅅ 객체값 전달이 실시간으로
>변경 됨으로 전송 완료 조건을 정해 커밋

## 세션
> Uni 메서드에서 
>  @WithSession 사용
> 메서드가 차단되고 반환


## 트랜젝션

### 코드 예제


```java
@POST
public Uni<RestResponse<Fruit>> create(Fruit fruit)
{
return
  Panache
    .withTransaction(fruit::persist)
      .replaceWith(RestResponse
        .status(CREATED, fruit));
}
```


```java

@POST
public Uni<Response> create(Fruit fruit)
{
if (fruit == null || fruit.id != null)
{
throw new WebApplicationException("Id was invalidly set on request.", 422);
}

return
  Panache
    .withTransaction(fruit::persist)
      .replaceWith(Response.ok(fruit)
        .status(CREATED)::build);
    }
```




```java
@WithTransaction
public Uni<Void> create(Person person)
{
/* Here we use the persistAndFlush()
shorthand method on a Panache repository
to persist to database then flush the changes.*/
return
  person
    .persistAndFlush()
      .onFailure(PersistenceException.class)
        .recoverWithItem
            (  () ->
                    {
                    LOG.error("Unable to create the parameter", pe);
                    //in case of error, I save it to disk
                    diskPersister.save(person);
                    return null;
                    }
            );

}
```
