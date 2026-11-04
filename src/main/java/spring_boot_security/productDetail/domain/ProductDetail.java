package spring_boot_security.productDetail.domain;

import lombok.Builder;
import lombok.Data;
import spring_boot_security.product.domain.entity.Product;

@Data
@Builder
public class ProductDetail {

    private Long id;
    private String specifications;
    private String warranty;
    private String provider;

    private Product product;
}
