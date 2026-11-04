package spring_boot_security.product.application.query.getById;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring_boot_security.common.application.mediator.RequestHandler;
import spring_boot_security.product.domain.entity.Product;
import spring_boot_security.product.domain.exception.ProductNotFoundException;
import spring_boot_security.product.domain.port.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetProductByIdHandler implements RequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

    private final ProductRepository productRepository;


    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {

        log.info("Getting product with id {}", request.getId());

        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new ProductNotFoundException(request.getId()));

        log.info("Found product with id {}", request.getId());

        return new GetProductByIdResponse(product);
    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }
}
