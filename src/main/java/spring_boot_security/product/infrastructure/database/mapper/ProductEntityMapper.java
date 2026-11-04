package spring_boot_security.product.infrastructure.database.mapper;

import org.mapstruct.*;
import spring_boot_security.category.domain.Category;
import spring_boot_security.category.infrastructure.CategoryEntity;
import spring_boot_security.product.domain.entity.Product;
import spring_boot_security.product.infrastructure.database.entity.ProductEntity;
import spring_boot_security.review.domain.Review;
import spring_boot_security.review.infrastructure.ReviewEntity;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProductEntityMapper {

    @Mapping(target = "productDetail.productEntity", ignore = true)
    ProductEntity mapToProductEntity(Product product);

    @Mapping(target = "productDetail.product", ignore = true)
    Product mapToProduct(ProductEntity productEntity);

    @Mapping(target = "product", ignore = true)
    Review mapToReview(ReviewEntity reviewEntity);

    @Mapping(target = "productEntity", ignore = true)
    ReviewEntity mapToReviewEntity(Review review);

    @Mapping(target = "products", ignore = true)
    Category mapToCategory(CategoryEntity categoryEntity);

    @Mapping(target = "products", ignore = true)
    CategoryEntity mapToCategoryEntity(Category category);

    @AfterMapping
    default void linkReviews(@MappingTarget ProductEntity productEntity) {
        if (productEntity.getReviews() != null) {
            productEntity.getReviews().forEach(
                    review -> review.setProductEntity(productEntity)
            );
        }
    }
}
