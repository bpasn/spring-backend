package com.ecommerce.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    @Column(name = "name", length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @Lob
    private String description;

    @OneToMany
    @JoinColumn(name = "image_id")
    private Set<ImageProduct> image;

    private BigDecimal price;
    private Number quantity;

}
