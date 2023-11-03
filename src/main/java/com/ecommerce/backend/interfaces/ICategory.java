package com.ecommerce.backend.interfaces;
import java.io.IOException;
import com.ecommerce.backend.controllers.categories.CreateCategoryRequest;

public interface ICategory {
    String create(CreateCategoryRequest request) throws IOException;
}
