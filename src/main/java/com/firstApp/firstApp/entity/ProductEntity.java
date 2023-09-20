package com.firstApp.firstApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "products")
public class ProductEntity extends BaseEntity{
    private String pName;
    private String pDescription;
    private Integer quantity;
    private String sku;
    private String image;
}
