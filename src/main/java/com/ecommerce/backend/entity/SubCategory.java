package com.ecommerce.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "sub_category")
public class SubCategory extends BaseEntity{
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;
}
