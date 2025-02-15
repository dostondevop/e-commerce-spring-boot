package uz.pdp.ecommerce_with_spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce_with_spring_boot.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
