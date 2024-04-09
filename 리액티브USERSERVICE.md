

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
