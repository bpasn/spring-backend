package com.ecommerce.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "order_item")
@EqualsAndHashCode(callSuper = true)
public class OrderItem extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Set<Product> product;
    private Number quantity;
}
