package spring_boot_security.product.application.query.getAll;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring_boot_security.common.application.mediator.RequestHandler;
import spring_boot_security.common.domain.PaginationResult;
import spring_boot_security.product.domain.entity.Product;
import spring_boot_security.product.domain.port.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllProductHandler implements RequestHandler<GetAllProductRequest, GetAllProductResponse> {

    private final ProductRepository productRepository;


    @Override
    public GetAllProductResponse handle(GetAllProductRequest request) {

        log.info("Getting all products");

        PaginationResult<Product> products = productRepository.findAll(request.getPaginationQuery(), request.getProductFilter());

        return new GetAllProductResponse(products);
    }

    @Override
    public Class<GetAllProductRequest> getRequestType() {
        return GetAllProductRequest.class;
    }
}
