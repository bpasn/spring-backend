package com.ecommerce.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "image_product")
@Data
public class ImageProductEntity extends BaseEntity{
    @Column(columnDefinition = "TEXT")
    private String image;

    @JoinColumn(name = "product_id",nullable = false)
    @ManyToOne
    private ProductEntity product;
}
