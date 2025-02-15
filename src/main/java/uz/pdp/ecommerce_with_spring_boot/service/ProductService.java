package uz.pdp.ecommerce_with_spring_boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce_with_spring_boot.entity.Product;
import uz.pdp.ecommerce_with_spring_boot.repo.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}

