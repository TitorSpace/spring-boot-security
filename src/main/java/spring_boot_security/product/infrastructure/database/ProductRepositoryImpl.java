package spring_boot_security.product.infrastructure.database;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import spring_boot_security.common.domain.PaginationQuery;
import spring_boot_security.common.domain.PaginationResult;
import spring_boot_security.product.domain.entity.Product;
import spring_boot_security.product.domain.entity.ProductFilter;
import spring_boot_security.product.domain.port.ProductRepository;
import spring_boot_security.product.infrastructure.database.entity.ProductEntity;
import spring_boot_security.product.infrastructure.database.mapper.ProductEntityMapper;
import spring_boot_security.product.infrastructure.database.repository.QueryProductRepository;
import spring_boot_security.product.infrastructure.database.specification.ProductSpecification;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {


    private final QueryProductRepository repository;

    private final ProductEntityMapper productEntityMapper;


    @Override
    public Product upsert(Product product) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(product);
        ProductEntity save = repository.save(productEntity);
        return productEntityMapper.mapToProduct(save);
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public Optional<Product> findById(Long id) {
        log.info("Finding product with id {}", id);
        return repository.findById(id).map(productEntityMapper::mapToProduct);
    }

    @Override
    public PaginationResult<Product> findAll(PaginationQuery paginationQuery, ProductFilter productFilter) {

        PageRequest pageRequest = PageRequest.of(
                paginationQuery.getPage(),
                paginationQuery.getSize(),
                Sort.by(Sort.Direction.fromString(paginationQuery.getDirection()), paginationQuery.getSortBy())
        );

        Specification<ProductEntity> specification = Specification.allOf(
                        ProductSpecification.byName(productFilter.getName())
                                .and(ProductSpecification.byDescription(productFilter.getDescription())))
                .and(ProductSpecification.byPrice(productFilter.getPriceMin(), productFilter.getPriceMax())


                );

        Page<ProductEntity> page = repository.findAll(specification, pageRequest);

        return new PaginationResult<>(
                page.getContent().stream().map(productEntityMapper::mapToProduct).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                (int) page.getTotalElements()
        );
    }

    @CacheEvict(value = "products", key = "#id")
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
