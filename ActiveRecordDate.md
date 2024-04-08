# Lombok 사용 가이드


> @Data[^1]
> > [^1]:getter, setter, toString, equals 및 hashCode 메소드를 생성
> > 
> @Builder(toBuilder = true)[^2]
> > [^2]:빌더패턴 코드 생성
> > 
> @NoArgsConstructor[^3]
> > [^3]:특성 초기화 생성자 호출
> > 
>@AllArgsConstructor[^4]
> >[^4]:Bean 생성자 호출
> >

> [!NOTE]
> Useful information that users should know, even when skimming content.

```
<dependent>
  <groupId>org.projectlombok</groupId> 
  <artifactId>lombok</artifactId> 
  <version>1.18.16</version> 
</dependent>
```



<details>

<summary>머메이드 다이어그램 샘플</summary>

### 머메이드[^6]
[^6]:머메이드 작성 기본 ` ```mermaid graph TD; A-->B; ``` `
```mermaid
graph TD;
    A-->B;
    A-->C;
    B-->D;
    C-->D;
```

</details>

# 활성 레코드 패턴 구현


<details>

<summary> 엔터티 클래스 작성 </summary>

### 엔터티 클래스 생성

```JAVA
@Entity
@Table(name="product")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brandName;

    private Double price;
}
```

</details>

<details>
<summary> 레포지토리 클래스 </summary>

### 엔터티 레포지토리 클래스 메서드 엑세스 제공 [^5]
`find` `list` `upate` `persits` ..구현 제공
  [^5]: `find` `list` `upate` `persits` ..구현 제공
  
```JAVA

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product>{
}

```

> 구현이 제공된 메서드 사용해 레포지토리클래스에 메소드 생성
>
> 
```java
public List<Product> findByName(String productName) {
    return this.list("name", WordUtils.capitalize(productName));
}

public List<Product> findByBrand(String productBrand) {
    return this.list("brandName",
                WordUtils.capitalize(productBrand));
}

public List<Product> findByNameAndBrand(String productName, String brandName) {
    return this.list("name = ?1 and brandName = ?2",
                WordUtils.capitalize(productName),
                WordUtils.capitalize(brandName));
}
```

> 레포지토리 overloading the method persist
> >데이터 전달 정규화하여 데이터 지속성 보장

```java
public void persist(Product product) {
    var productName = WordUtils.capitalize(product.getName());
    var brandName = WordUtils.capitalize(product.getBrandName());

    product.setName(productName);
    product.setBrandName(brandName);

    PanacheRepository.super.persist(product);
}
```

> 객체 업데이트
>  객체를 찾고 데이터 대체 구현
>  Optional 사용해 null 객체 예외 처리
> 
```java
public Optional<Product> update(Product product) {
    final var id = product.getId();
    var savedOpt = this.findByIdOptional(id);
    if (savedOpt.isEmpty()) {
        return Optional.empty();
    }

    var saved = savedOpt.get();
    saved.setName(product.getName());
    saved.setPrice(product.getPrice());
    saved.setBrandName(product.getBrandName());

    return Optional.of(saved);
}
```

</details>

<details>
<summary> 서비스 클래스  </summary>
  
## 서비스 레이어 구현
> 검증이 필요한 경우 서비스 레이어 생성하여 사용
> 
> 또는 검증과정 없이 컨트롤러에서 직접 레포지토리 제어

### CDI BEAN INJECTION 
> @ApplicationScoped 를 클래스에 사용 시 해당 클래스를 라이프사이클 범위를 갖는 빈으로 정의 한다
> 
> 레포지토리 또는 엔터티의 인스턴스를 인수로 요구하는 모든 생성자를 주입 하고
> 프레임워크에서 라이프사이클 관리(생성및제거 제거) 한다


```JAVA
@ApplicationScoped
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts(String productName, String brandName) {
        if (StringUtils.isNotBlank(productName) && StringUtils.isNotBlank(brandName)) {
            return productRepository.findByNameAndBrand(productName, brandName);
        } else if (StringUtils.isNotBlank(brandName)) {
            return productRepository.findByBrand(brandName);
        } else if (StringUtils.isNotBlank(productName)) {
            return productRepository.findByName(productName);
        }

        return productRepository.listAll();
    }

    public Optional<Product> findProductById(long id) {
        return productRepository.findByIdOptional(id);
    }

    @Transactional
    public void create(Product product) throws InvalidAttributesException {
        if (product.getId() != null) {
            throw new InvalidAttributesException("Id must not be filled");
        }
        Validate.notNull(product, "Product can not be null");
        Validate.notBlank(product.getBrandName(), "Brand name can not be empty");
        Validate.notBlank(product.getName(), "Name can not be empty");

        productRepository.persist(product);
    }

    @Transactional
    public Product replace(long productId, Product product) {
        product.setId(productId);
        return productRepository.update(product).orElseThrow(() -> new InvalidParameterException("Product not found"));
    }

    @Transactional
    public boolean delete(long productId) {
        return productRepository.deleteById(productId);
    }
}
```


</details>











