package com.ecommerce.backend.controllers.product;

import java.math.BigDecimal;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Setter
@Getter
public class CreateProductRequest {
    @NotNull(message = "Field Name is required.")
    private String name;

    private String description;

    @NotNull(message = "Field Price is required.")
    private BigDecimal price;

    @NotNull(message = "Field Stock Quantity is required.")
    private int stockQuantity;
    
    @NotNull(message = "Field Category Name is required.")
    private String categoryName;

    @NotNull(message = "Field Original File is required.")
    private String originalFile;

    @NotNull(message = "Field Image is required.")
    private String imageBase64;
}
