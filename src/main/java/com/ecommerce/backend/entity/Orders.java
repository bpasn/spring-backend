package com.ecommerce.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Users user;

    private LocalDateTime orderDate;

    @Column(name = "status", length = 20)
    private String status;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(length = 255)
    private String shippingAddress;
}
