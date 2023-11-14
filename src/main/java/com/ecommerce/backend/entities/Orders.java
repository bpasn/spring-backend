package com.ecommerce.backend.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
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

    @OneToMany
    @JoinColumn(name = "order_item_id")
    private List<OrderItem> orderItem;
    private Boolean status = false;
    private BigDecimal total;
    private String phone;
    private String address;




}
