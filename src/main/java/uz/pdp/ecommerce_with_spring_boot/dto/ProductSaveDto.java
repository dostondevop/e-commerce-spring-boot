package uz.pdp.ecommerce_with_spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveDto {
    private String productName;
    private Integer productPrice;
    private Integer attachmentId;
    private Integer categoryId;
}
