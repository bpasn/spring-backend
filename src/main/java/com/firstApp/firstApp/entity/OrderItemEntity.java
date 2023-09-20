package com.firstApp.firstApp.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "order_item")
public class OrderItemEntity extends BaseEntity{
    private Integer uId;
    private Integer pId;
    private Date expired;
    private Boolean status;
    private Integer addressId;
}
