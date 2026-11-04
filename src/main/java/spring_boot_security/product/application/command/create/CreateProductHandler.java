package spring_boot_security.product.application.command.create;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring_boot_security.common.application.mediator.RequestHandler;
import spring_boot_security.common.infrastructure.util.FileUtils;
import spring_boot_security.product.domain.entity.Product;
import spring_boot_security.product.domain.port.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateProductHandler implements RequestHandler<CreateProductRequest, CreateProductResponse> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;

    @Override
    public CreateProductResponse handle(CreateProductRequest request) {

        log.info("Creating product");

        String uniqueFilename = fileUtils.saveProductImage(request.getFile());

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(uniqueFilename)
                .build();

        Product storedProduct = productRepository.upsert(product);

        log.info("Created product with id {}", storedProduct.getId());

        return new CreateProductResponse(storedProduct);
    }


    @Override
    public Class<CreateProductRequest> getRequestType() {
        return CreateProductRequest.class;
    }
}
