package com.ecommerce.backend.controllers.categories;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class CategoriesResponse {
    private String categoryName;
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
