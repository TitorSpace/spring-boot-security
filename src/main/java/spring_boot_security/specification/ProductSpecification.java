package spring_boot_security.specification;

import org.springframework.data.jpa.domain.Specification;
import spring_boot_security.entity.ProductEntity;

public class ProductSpecification {

    public static Specification<ProductEntity> byName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<ProductEntity> byDescription(String description) {
        return (root, query, criteriaBuilder) -> description == null ? null : criteriaBuilder.like(root.get("description"), "%" + description + "%");
    }

    public static Specification<ProductEntity> byPrice(Double priceMin, Double priceMax) {
        return (root, query, criteriaBuilder) -> priceMin == null || priceMax == null ? null : criteriaBuilder.between(root.get("price"), priceMin, priceMax);
    }


}
