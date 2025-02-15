package uz.pdp.ecommerce_with_spring_boot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDto {
    private Integer id;
    private Integer amount;
}
