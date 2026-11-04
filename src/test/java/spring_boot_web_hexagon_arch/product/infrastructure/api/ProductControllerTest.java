package spring_boot_security.product.infrastructure.api;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring_boot_security.common.application.mediator.Mediator;
import spring_boot_security.product.infrastructure.api.mapper.ProductMapper;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock //Create an instance of class mediator but internally create a proxy class that intercept all the methods
    private Mediator mediator;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductController productController;

//    @Test
//    public void getAllProducts() {
//
//        GetAllProductResponse getAllProductResponse = new GetAllProductResponse(List.of(
//                Product.builder().id(1L).build(),
//                Product.builder().id(2L).build()
//        ));
//        when(mediator.dispatch(new GetAllProductRequest())).thenReturn(getAllProductResponse);
//
//        ProductDto productDto = new ProductDto();
//        productDto.setId(1L);
//
//        when(productMapper.mapToProductDto(any(Product.class))).thenReturn(productDto);
//        ResponseEntity<List<ProductDto>> response = productController.getAllProduct(0, 5);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//
//        List<ProductDto> products = response.getBody();
//        assertEquals(2, products.size());
//    }
}