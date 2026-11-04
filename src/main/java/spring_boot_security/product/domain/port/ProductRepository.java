package spring_boot_security.product.domain.port;

import spring_boot_security.common.domain.PaginationQuery;
import spring_boot_security.common.domain.PaginationResult;
import spring_boot_security.product.domain.entity.Product;
import spring_boot_security.product.domain.entity.ProductFilter;

import java.util.Optional;

public interface ProductRepository {

    Product upsert(Product product);

    Optional<Product> findById(Long id);

    PaginationResult<Product> findAll(PaginationQuery paginationQuery, ProductFilter productFilter);

    void deleteById(Long id);
}
