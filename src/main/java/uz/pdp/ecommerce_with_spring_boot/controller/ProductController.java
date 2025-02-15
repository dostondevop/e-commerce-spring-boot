package uz.pdp.ecommerce_with_spring_boot.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce_with_spring_boot.entity.Product;
import uz.pdp.ecommerce_with_spring_boot.dto.ProductSaveDto;
import uz.pdp.ecommerce_with_spring_boot.service.FilterService;
import uz.pdp.ecommerce_with_spring_boot.repo.ProductRepository;
import uz.pdp.ecommerce_with_spring_boot.repo.CategoryRepository;
import uz.pdp.ecommerce_with_spring_boot.repo.AttachmentRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final FilterService filterService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final AttachmentRepository attachmentRepository;

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable Integer id) {
        return productRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductSaveDto productSaveDto) {
        Product product = Product
                .builder()
                .name(productSaveDto.getProductName())
                .price(productSaveDto.getProductPrice())
                .category(categoryRepository.findById(productSaveDto.getCategoryId()).orElseThrow())
                .attachment(attachmentRepository.findById(productSaveDto.getAttachmentId()).orElseThrow())
                .build();
        productRepository.save(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody ProductSaveDto productSaveDto, @PathVariable Integer id) {
        Product product = Product
                .builder()
                .id(id)
                .name(productSaveDto.getProductName())
                .price(productSaveDto.getProductPrice())
                .category(categoryRepository.findById(productSaveDto.getCategoryId()).orElseThrow())
                .attachment(attachmentRepository.findById(productSaveDto.getAttachmentId()).orElseThrow())
                .build();
        productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Integer categoryId) {
        List<Product> products = filterService.filterProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }
}