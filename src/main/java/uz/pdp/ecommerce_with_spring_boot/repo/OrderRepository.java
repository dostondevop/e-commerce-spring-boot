package uz.pdp.ecommerce_with_spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce_with_spring_boot.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
