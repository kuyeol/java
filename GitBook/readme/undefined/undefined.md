---
description: User.java
---

# 유저엔터티

## 유저엔터티 정의

### User.java

## Create a new user

<mark style="color:green;">`POST`</mark> `/users`

<details>

<summary></summary>



{% code title="" overflow="wrap" lineNumbers="true" fullWidth="true" %}
```
// Some code


```
{% endcode %}



</details>

{% tabs %}
{% tab title="200" %}
<table data-full-width="true"><thead><tr><th align="center">임포트 클래스</th><th>클래스</th><th>정의</th><th>비고</th></tr></thead><tbody><tr><td align="center">패키지 위치</td><td>클래스</td><td>정의</td><td>비고</td></tr><tr><td align="center">내부</td><td><code>.config.Constants;</code></td><td>cacheProvider</td><td>Caffeine</td></tr><tr><td align="center">io.quarkus</td><td><code>.cache.CacheResult;</code></td><td>cacheProvider</td><td>Caffeine</td></tr><tr><td align="center">io.quarkus</td><td><code>.hibernate.orm.panache.PanacheEntityBase;</code></td><td>databaseType</td><td>sql</td></tr><tr><td align="center">io.quarkus</td><td><code>.runtime.annotations.RegisterForReflection;</code></td><td>databaseType</td><td>sql</td></tr><tr><td align="center">io.quarkus</td><td><code>.mongodb.panache.common.MongoEntity;</code></td><td>databaseType</td><td><a href="undefined.md#undefined-3">ㅇㄹㅇ</a></td></tr><tr><td align="center">io.quarkus</td><td>.mongodb.panache.PanacheMongoEntityBase;</td><td>databaseType</td><td><br></td></tr><tr><td align="center">org.bson</td><td>.codecs.pojo.annotations.BsonId;</td><td>databaseType</td><td><br></td></tr><tr><td align="center">org.bson</td><td>.codecs.pojo.annotations.BsonIgnore;</td><td><br></td><td><br></td></tr><tr><td align="center">java</td><td>.io.Serializable;</td><td><br></td><td><br></td></tr><tr><td align="center">java</td><td>.time.Instant;</td><td><br></td><td><br></td></tr><tr><td align="center">java</td><td>.util.HashSet;</td><td><br></td><td><br></td></tr><tr><td align="center">io.quarkus</td><td>.panache.common.Page;</td><td><br></td><td><br></td></tr><tr><td align="center">java</td><td>.util.List;</td><td><br></td><td><br></td></tr><tr><td align="center">java</td><td>.util.Optional;</td><td><br></td><td><br></td></tr><tr><td align="center">java</td><td>.util.Set;</td><td><br></td><td><br></td></tr><tr><td align="center">jakarta</td><td>.persistence.*;</td><td><br></td><td><br></td></tr><tr><td align="center">org.hibernate</td><td>.annotations.BatchSize;</td><td><br></td><td><br></td></tr><tr><td align="center">jakarta.json</td><td>.bind.annotation.JsonbTransient;</td><td><br></td><td><br></td></tr><tr><td align="center">jakarta.validation</td><td>.constraints.Email;</td><td><br></td><td><br></td></tr><tr><td align="center">jakarta.validation</td><td>.constraints.NotNull;</td><td><br></td><td><br></td></tr><tr><td align="center">jakarta.validation</td><td>.constraints.Pattern;</td><td><br></td><td><br></td></tr><tr><td align="center">jakarta.validation</td><td>.constraints.Size;</td><td><br></td><td><br></td></tr><tr><td align="center">org.hibernate</td><td>.annotations.CacheConcurrencyStrategy;</td><td><br></td><td><br></td></tr><tr><td align="center">org.hibernate</td><td>.annotations.Cache;</td><td><br></td><td><br></td></tr><tr><td align="center"><br></td><td><br></td><td><br></td><td><br></td></tr><tr><td align="center"></td><td></td><td></td><td></td></tr></tbody></table>

```json
{
  "id": 1,
  "name": "John",
  "age": 30
}
```

## 링크

<table><thead><tr><th></th><th width="142"></th><th></th></tr></thead><tbody><tr><td><mark style="color:blue;">```</mark></td><td><code>```</code></td><td><a data-footnote-ref href="#user-content-fn-1">a</a></td></tr><tr><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td></tr></tbody></table>

```
// Some code

```
{% endtab %}

{% tab title="400" %}
```json
{
  "error": "Invalid request"
}
```
{% endtab %}

{% tab title="Untitled" %}

{% endtab %}
{% endtabs %}



<table><thead><tr><th>패키지</th><th>클래스</th><th width="97" align="center">사용처</th><th></th></tr></thead><tbody><tr><td></td><td></td><td align="center"></td><td></td></tr><tr><td></td><td></td><td align="center"></td><td></td></tr><tr><td></td><td></td><td align="center"></td><td></td></tr></tbody></table>

[^1]: 
