package com.firstApp.firstApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_item")
public class OrderItemEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrdersEntity orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity products;

    private Integer quantity;

    @Column(precision = 10,scale = 2)
    private BigDecimal unitPrice;
}
