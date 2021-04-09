package excel.upload.service;

import excel.upload.entity.Product;
import excel.upload.entity.ProductRepository;
import excel.upload.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product detail(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("no product id : " + id));;
    }
}
