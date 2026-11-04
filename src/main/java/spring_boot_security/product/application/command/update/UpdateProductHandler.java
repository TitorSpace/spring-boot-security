package spring_boot_security.product.application.command.update;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring_boot_security.category.domain.Category;
import spring_boot_security.category.infrastructure.CategoryEntityMapper;
import spring_boot_security.category.infrastructure.QueryCategoryRepository;
import spring_boot_security.common.application.mediator.RequestHandler;
import spring_boot_security.product.domain.entity.Product;
import spring_boot_security.product.domain.exception.ProductNotFoundException;
import spring_boot_security.product.domain.port.ProductRepository;
import spring_boot_security.productDetail.domain.ProductDetail;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class UpdateProductHandler implements RequestHandler<UpdateProductRequest, Void> {

    private final ProductRepository productRepository;
    private final QueryCategoryRepository queryCategoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public Void handle(UpdateProductRequest request) {

        log.info("Updating product with id {}", request.getId());

        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new ProductNotFoundException(request.getId()));

        ProductDetail productDetail = product.getProductDetail();
        productDetail.setProvider(request.getProvider());
        product.getReviews().add(request.getReview());

        Category category = queryCategoryRepository.findById(request.getCategoryId())
                .map(categoryEntityMapper::maptoCategory)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.getCategories().add(category);
        productRepository.upsert(product);

        if (product.getId() == 8) throw new RuntimeException("Error updating product with id 8");
        log.info("Updated product with id {}", request.getId());

        return null;
    }

    @Override
    public Class<UpdateProductRequest> getRequestType() {
        return UpdateProductRequest.class;
    }
}
