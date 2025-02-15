package uz.pdp.ecommerce_with_spring_boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce_with_spring_boot.dto.CartDto;
import uz.pdp.ecommerce_with_spring_boot.entity.Order;
import uz.pdp.ecommerce_with_spring_boot.entity.OrderItem;
import uz.pdp.ecommerce_with_spring_boot.repo.OrderRepository;
import uz.pdp.ecommerce_with_spring_boot.repo.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Order save(List<CartDto> carts) {
        LocalDateTime now = LocalDateTime.now();
        return orderRepository.save(new Order(orderItems(carts), now));
    }

    private List<OrderItem> orderItems(List<CartDto> carts) {
        return carts.stream().map(cartDto -> new OrderItem(productRepository.findById(cartDto.getId())
                .orElseThrow(()->new RuntimeException("Product not found")), cartDto.getAmount())).toList();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<OrderItem> orderItems(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found.")).getOrderItems();
    }

}
