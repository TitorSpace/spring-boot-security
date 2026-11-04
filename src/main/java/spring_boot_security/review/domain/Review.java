package spring_boot_security.review.domain;

import lombok.Builder;
import lombok.Data;
import spring_boot_security.product.domain.entity.Product;

@Data
@Builder
public class Review {

    private Long id;
    private String comment;
    private String score;

    private Product product;
}
