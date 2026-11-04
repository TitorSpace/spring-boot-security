package spring_boot_security.product.application.query.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring_boot_security.common.application.mediator.Request;
import spring_boot_security.common.domain.PaginationQuery;
import spring_boot_security.product.domain.entity.ProductFilter;

@Data
@AllArgsConstructor
public class GetAllProductRequest implements Request<GetAllProductResponse> {

    PaginationQuery paginationQuery;
    ProductFilter productFilter;
}
