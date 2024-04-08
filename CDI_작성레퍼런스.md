
> [!note]
> <details>
> <summary> 레퍼런스 링크 모음 </summary>
>  
> ### [CDI 자카르타 사양 레퍼런스 링크](https://jakarta.ee/specifications/cdi/2.0/cdi-spec-2.0.html)
>
> ### [QUARKUS 레퍼런스](https://quarkus.io/guides/cdi-reference)
> 
> </details>



# BEAN 이란? 
> [!NOTE]
> BEAN?
>

 ```java
 public class BookShop extends Business implements Shop<Book> {
 //...  } 
```

위 코드에서 bean 타입은 아래 와 같다
<strong> `BookShop`, `Business`, `Shop<Book>`, `Object`  </strong>

# Bean위 범위 선언

<strong> `@ApplicationScoped`</strong> 로 범위를 지정할수 있다 

```java
public class Shop {

   @Produces @ApplicationScoped @All
   public List<Product> getAllProducts() { ... }

   @Produces @SessionScoped @WishList
   public List<Product> getWishList() { ..... }
```



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

<summary> 자카르타 서버페이스 예제 </summary>

# 자카르타 서버페이스 예제
---
## 객체 식별 클래스

> `@Model` BEAN을 모델 객체로 식별 하기위한 어노테이션

```java
@Model
public class Credentials {

    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
```

## HTTP 세션 바인딩

```java
@SessionScoped
 @Model
public class Login implements Serializable {

@Inject
Credentials credentials;

@Inject
@Users
EntityManager userDatabase;

//클래스 외부에서 접근 하지 못하도록 private 범위 지정
    private CriteriaQuery<User> query;
    private Parameter<String> usernameParam;
    private Parameter<String> passwordParam;

    private User user;

// 빈 컨텍스트 범위 지정
// PRIVATE 데이터를 카피하여 문자열 타입으로 객체 생성
    @Inject
    void initQuery(@Users EntityManagerFactory emf) {
//CriteriaBuilder 타입으로 변수 cb 생성 메서드 getCriteriaBuilder()를  EntityManagerFactory클래스에서 변수를 emf로 지정하여 메서드 호출
        CriteriaBuilder cb = emf.getCriteriaBuilder();
//userparam 변수는 위에 빌더에서 파라미터를 문자열로 호출
        usernameParam = cb.parameter(String.class);
        passwordParam = cb.parameter(String.class);
//쿼리생성 메서드를 유저 클래스 파라미터로 정의하여 호출
        query = cb.createQuery(User.class);
//리스트 유저 쿼리를 유저 클래스에서 호출
        Root<User> u = query.from(User.class);
//위에 변수 u를 사용하여 쿼리문 정의 
        query.select(u);
        query.where( cb.equal(u.get(User_.username), usernameParam),
                     cb.equal(u.get(User_.password), passwordParam) );
    }

    public void login() {
//리스트 유저 객체 results 변수를 디비쿼리메서드를 사용해 지정
        List<User> results = userDatabase.createQuery(query)
//전달할 파라미터에 위에 정의된 객체를 매핑
//usernameParam을 크레덴셜클래스 get유저네임 메서드로 호출
            .setParameter(usernameParam, credentials.getUsername())
            .setParameter(passwordParam, credentials.getPassword())

            .getResultList();

        if ( !results.isEmpty() ) {
            user = results.get(0);
        }

    }

    public void logout() {
        user = null;
    }

    public boolean isLoggedIn() {
        return user!=null;
    }

    @Produces @LoggedIn User getCurrentUser() {
        if (user==null) {
            throw new NotLoggedInException();
        }
        else {
            return user;
        }
    }

}
```




```java
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Users {}

```


```java
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface LoggedIn {}
```

@interface LoggedIn 으로 작성하여
아래 클래스에서 @LoggedIn 사용

```java
@Model
public class DocumentEditor {

    @Inject
Document document;

    @Inject
 @LoggedIn
User currentUser;

    @Inject
@Documents
EntityManager docDatabase;

    public void save() {
        document.setCreatedBy(currentUser);
        em.persist(document);
    }

}
```

```java

@Stateful @SessionScoped @Model
public class Login {

    @Inject Credentials credentials;
    @Inject @Users EntityManager userDatabase;

    ...

    private User user;

    @Inject
    void initQuery(@Users EntityManagerFactory emf) {
       ...
    }

    @TransactionAttribute(REQUIRES_NEW)
    @RolesAllowed("guest")
    public void login() {
        ...
    }

    public void logout() {
        user = null;
    }

    public boolean isLoggedIn() {
        return user!=null;
    }

    @RolesAllowed("user")
    @Produces @LoggedIn User getCurrentUser() {
        ...
    }

}
```



```java
@Secure @Interceptor
public class AuthorizationInterceptor {

    @Inject @LoggedIn User user;
    @Inject Logger log;

    @AroundInvoke
    public Object authorize(InvocationContext ic) throws Exception {
        try {
            if ( !user.isBanned() ) {
                log.fine("Authorized");
                return ic.proceed();
            }
            else {
                log.fine("Not authorized");
                throw new NotAuthorizedException();
            }
        }
        catch (NotAuthenticatedException nae) {
            log.fine("Not authenticated");
            throw nae;
        }
    }

}
```


```java
@Inherited
@InterceptorBinding
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface Secure {}
```


```java
@Model
public class DocumentEditor {

    @Inject Document document;
    @Inject @LoggedIn User user;
    @Inject @Documents EntityManager em;

    @Secure
    public void save() {
        document.setCreatedBy(currentUser);
        em.persist(document);
    }

}
```

</details>

---






























