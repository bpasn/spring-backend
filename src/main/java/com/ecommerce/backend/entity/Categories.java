package com.ecommerce.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "categories",uniqueConstraints = {
        @UniqueConstraint(
                name = "category_name_unique",
                columnNames = "name"
        )
})
public class Categories extends BaseEntity {

    @Column(nullable = false,length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
