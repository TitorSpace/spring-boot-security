package spring_boot_web_jpa.product.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Data;
import spring_boot_web_jpa.category.infrastructure.CategoryEntity;
import spring_boot_web_jpa.productDetail.infrastructure.ProductDetailEntity;
import spring_boot_web_jpa.review.infrastructure.ReviewEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 500)
    private String description;
    private Double price;
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity productDetail;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories = new ArrayList<>();
}
