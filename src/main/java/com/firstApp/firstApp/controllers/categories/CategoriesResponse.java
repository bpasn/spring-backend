package com.firstApp.firstApp.controllers.categories;

import lombok.Data;

@Data
public class CategoriesResponse {
    private Integer id;
    private String categoryName;
    private String description;
    private String image;
}
