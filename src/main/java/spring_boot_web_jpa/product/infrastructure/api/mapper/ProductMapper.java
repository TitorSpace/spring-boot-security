package spring_boot_web_jpa.product.infrastructure.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import spring_boot_web_jpa.category.domain.Category;
import spring_boot_web_jpa.product.application.command.create.CreateProductRequest;
import spring_boot_web_jpa.product.application.command.update.UpdateProductRequest;
import spring_boot_web_jpa.product.domain.entity.Product;
import spring_boot_web_jpa.product.infrastructure.api.dto.CreateProductDto;
import spring_boot_web_jpa.product.infrastructure.api.dto.ProductDto;
import spring_boot_web_jpa.product.infrastructure.api.dto.ReviewDto;
import spring_boot_web_jpa.product.infrastructure.api.dto.UpdateProductDto;
import spring_boot_web_jpa.review.domain.Review;

import java.util.List;

//Mapper has diff attrs. ComponentModel now everytime that starts is going the implement in runtime the class of this interface
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    CreateProductRequest mapToCreateProductRequest(CreateProductDto createProductDto);

    UpdateProductRequest mapToUpdateProductRequest(UpdateProductDto updateProductDto);

    @Mapping(target = "provider", source = "productDetail.provider")
    ProductDto mapToProductDto(Product product);

    @Mapping(target = "product", ignore = true)
    Review mapToReview(ReviewDto reviewDto);

    default List<String> mapToCategoryNames(List<Category> categories) {
        return categories.stream().map(Category::getName).toList();
    }

}
