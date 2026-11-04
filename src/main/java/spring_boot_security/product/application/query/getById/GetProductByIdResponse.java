package spring_boot_security.product.application.query.getById;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring_boot_security.product.domain.entity.Product;

@Data
@AllArgsConstructor
public class GetProductByIdResponse {

    private Product product;

}
