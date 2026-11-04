package spring_boot_security.product.application.query.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring_boot_security.common.domain.PaginationResult;
import spring_boot_security.product.domain.entity.Product;

@Data
@AllArgsConstructor
public class GetAllProductResponse {

    private PaginationResult<Product> productsPage;

}
