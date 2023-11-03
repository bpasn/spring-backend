package com.ecommerce.backend.controllers.categories;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest (
    @NotNull(message = "Categories is required")
    @Size(min = 2)
    String name
){}
