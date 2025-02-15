package uz.pdp.ecommerce_with_spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce_with_spring_boot.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(Integer categoryId);
}
