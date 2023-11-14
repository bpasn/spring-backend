package com.ecommerce.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "image_product")
@Data
public class ImageProduct extends BaseEntity{
    @Lob
    private String image;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
