package spring_boot_security.category.infrastructure;

import jakarta.persistence.*;
import lombok.Data;
import spring_boot_security.product.infrastructure.database.entity.ProductEntity;

import java.util.List;

@Data
@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    List<ProductEntity> products;
}
