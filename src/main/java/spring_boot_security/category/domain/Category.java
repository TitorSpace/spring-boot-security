package spring_boot_security.category.domain;

import lombok.Builder;
import lombok.Data;
import spring_boot_security.product.domain.entity.Product;

import java.util.List;

@Data
@Builder
public class Category {

    private Long id;
    private String name;

    List<Product> products;
}
