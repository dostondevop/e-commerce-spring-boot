package uz.pdp.ecommerce_with_spring_boot.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce_with_spring_boot.dto.CartDto;
import uz.pdp.ecommerce_with_spring_boot.entity.Order;
import uz.pdp.ecommerce_with_spring_boot.entity.OrderItem;
import uz.pdp.ecommerce_with_spring_boot.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String addOrder(@RequestBody List<CartDto> carts) {
        orderService.save(carts);
        return "success";
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public List<OrderItem> getOrder(@PathVariable Integer id) {
        return orderService.orderItems(id);
    }
}