package uz.pdp.ecommerce_with_spring_boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce_with_spring_boot.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterService {
    private final ProductService productService;

    public List<Product> filterProductsByCategory(Integer categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
