package spring_boot_security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spring_boot_security.entity.ProductEntity;
import spring_boot_security.mapper.ProductEntityMapper;
import spring_boot_security.product.domain.entity.Product;
import spring_boot_security.repository.QueryProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class ProductRepositoryImplTest {

    @Mock
    private QueryProductRepository repository;

    @Mock
    private ProductEntityMapper productEntityMapper;

    @InjectMocks
    private ProductRepositoryImpl productRepository;

    @Test
    void shouldReturnProductWhenFound() {

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new ProductEntity()));
        Mockito.when(productEntityMapper.mapToProduct(any(ProductEntity.class))).thenReturn(Product.builder().id(1L).build());

        Optional<Product> optionalProduct = productRepository.findById(1L);

        assertTrue(optionalProduct.isPresent());
    }

    @Test
    void shouldNotReturnProductWhenFound() {

        Optional<Product> optionalProduct = productRepository.findById(1L);

        assertTrue(optionalProduct.isEmpty());
    }

}