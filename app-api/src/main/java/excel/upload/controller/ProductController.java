package excel.upload.controller;

import excel.upload.entity.Product;
import excel.upload.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> list(){
        return productService.list();
    }

    @GetMapping("/products/{id}")
    public  Product detail(@PathVariable Long id) {
        return productService.detail(id);
    }

}
