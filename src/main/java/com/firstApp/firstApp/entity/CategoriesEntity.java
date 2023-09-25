package com.firstApp.firstApp.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "categories")
@Data
public class CategoriesEntity extends BaseEntity {
private String cName;
private String cDescription;
private String cImage;
}
