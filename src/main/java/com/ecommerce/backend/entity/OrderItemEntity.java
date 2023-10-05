package com.ecommerce.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemEntity that)) return false;
        return Objects.equals(getOrders(), that.getOrders()) && Objects.equals(getProducts(), that.getProducts()) && Objects.equals(getQuantity(), that.getQuantity()) && Objects.equals(getUnitPrice(), that.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrders(), getProducts(), getQuantity(), getUnitPrice());
    }
}
