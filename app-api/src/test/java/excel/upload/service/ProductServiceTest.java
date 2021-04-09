package excel.upload.service;

import excel.upload.entity.Product;
import excel.upload.entity.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void testList(){

        Product product = Product.builder()
                .id(1L)
                .name("dummy-name-existed")
                .price(2500)
                .weight(3.1)
                .description("dummy-name-description")
                .imgUrl("dummy-name-imgUrl")
                .build();

        given(productRepository.findAll()).willReturn(List.of(product));
        List<Product> products = productService.list();
    }

}
