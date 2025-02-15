package uz.pdp.ecommerce_with_spring_boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private LocalDateTime createdAt;

    public Order(List<OrderItem> orderItems, LocalDateTime createdAt) {
        this.orderItems = orderItems;
        this.createdAt = createdAt;
    }
}
