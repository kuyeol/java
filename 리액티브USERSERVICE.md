

> @Entity[^1]
> [^1]:엔터티 정의
> 
> @NoArgsConstructor
> 
> @AllArgsConstructor
> 
> @Builder
> 
> @Cacheable
> 
> @Getter
> 
> @Table(indexes = {
> @Index(name = "shopping_cart_item_cart_product_index", columnList = "cart_id, product_id"),})
> 
> public class ShoppingCartItem extends PanacheEntityBase {
>
>  @Id
> 
>  @GeneratedValue(strategy = GenerationType.IDENTITY)
> 
>  @JsonbTransient[^@JsonbTransient]
> 
> [^@JsonbTransient]: 필드 또는 타입이 Json 매핑되어 representaion 되는걸 방지
> 

    
    public Long id;

    @Column(name = "total_price", precision = 21, scale = 2)
    public BigDecimal totalPrice;

    @Column(name = "quantity")
    public Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JsonbTransient
    public ShoppingCart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Product product;


    public static Multi<ShoppingCartItem> findByCartIdByProductId(Long cartId, Long productId) {
        return stream("cart.id = ?1 and product.id = ?2", cartId, productId);
    }

    
    public String toString() {
        return this.getClass().getSimpleName() + "<" + this.id + ">";
    }
    
}

# 관련링크
## [vert.x 레퍼런스 sql auth](https://vertx.io/docs/vertx-auth-sql-client/java/)
### 내용 요약


#### 정보 저장
```
//해싱알고리즘 객체 생성
//(알고리즘명,작업,원본텍스트암호)
String hash = sqlAuth.hash(
// hashing algorithm (OWASP recommended)
 "pbkdf2",
 // secure random salt
  VertxContextPRNG.current().nextString(32),
  "sausages" // password
);

// save to the database
//데이터 베이스 저장 쿼리
//클라이언트객체에 쿼리 문지정 실행내용 튜플("스트링아이디",해쉬)행으로 보냄
sqlClient
  .preparedQuery("INSERT INTO users (username, password) VALUES ($1, $2)")
  .execute(Tuple.of("tim", hash))
  .onSuccess(rowset -> {
    // password updated
  });
```


> 암호화 코드
>
> 유형은 사용되는 JVM 버전에 따라 다르기 때문에 매우 중요합니다. 9 이전에는 기본값이 jksJVM 관련이며 그 이후에는 pkcs12공통 표준입니다.
> 
```
String token = VertxContextPRNG.current(vertx).nextString(32);
// Generate a secure random integer
int randomInt = VertxContextPRNG.current(vertx).nextInt();

//로컬저장소에서 모듈로드 방식
KeyStoreOptions options = new KeyStoreOptions()
  .setPath("/path/to/keystore/file")
  .setType("pkcs8")
  .setPassword("keystore-password")
  .putPasswordProtection("key-alias", "alias-password");
```



#### 저장 정보로 인증


```
//정보 전달 객체 생성-> 객체에 전달 데이터 PUT
JsonObject authInfo = new JsonObject()
  .put("username", "tim")
  .put("password", "sausages");
//프로바이더메서드에 정보전달 객체 파라미터로 전달 성공시 출력 실패시 실패 메세지 출력
authProvider.authenticate(authInfo)
  .onSuccess(user -> System.out.println("User: " + user.principal()))
  .onFailure(err -> {
  System.out.println("User: " +"없습니다")
  });
```
  



