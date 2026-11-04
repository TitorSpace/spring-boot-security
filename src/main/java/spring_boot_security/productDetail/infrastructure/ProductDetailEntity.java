package spring_boot_security.productDetail.infrastructure;

import jakarta.persistence.*;
import lombok.Data;
import spring_boot_security.product.infrastructure.database.entity.ProductEntity;

@Data
@Entity
@Table(name = "product_details")
public class ProductDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specifications;
    private String warranty;
    private String provider;

    @OneToOne(mappedBy = "productDetail")
    private ProductEntity productEntity;


}
