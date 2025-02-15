package uz.pdp.ecommerce_with_spring_boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Attachment attachment;
}
