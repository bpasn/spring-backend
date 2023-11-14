package com.ecommerce.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "brand",uniqueConstraints = {
        @UniqueConstraint(
                name = "brand_name_unique",
                columnNames = "name"
        )
})
@Data
@EqualsAndHashCode(callSuper = true)
public class Brand extends BaseEntity{
private String name;
private String image;
}
