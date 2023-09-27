package com.ecommerce.backend.controllers.categories;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class CategoriesResponse {
    private Integer id;
    private String categoryName;
    private String description;
    private String image;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
