package spring_boot_web_jpa.product.infrastructure.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import spring_boot_web_jpa.product.infrastructure.database.entity.ProductEntity;
import spring_boot_web_jpa.product.infrastructure.database.repository.QueryProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ProductRepositoryImplJpaTest {

    @Autowired
    private QueryProductRepository repository;

    @Test
    void shouldReturnProductWhenFound() {

        ProductEntity productEntity = new ProductEntity();
        ProductEntity save = repository.save(productEntity);

        Optional<ProductEntity> optionalProduct = repository.findById(save.getId());

        assertTrue(optionalProduct.isPresent());
    }

    @Test
    void shouldNotReturnProductWhenFound() {

        Optional<ProductEntity> optionalProduct = repository.findById(1L);

        assertTrue(optionalProduct.isEmpty());
    }

}