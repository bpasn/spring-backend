package com.ecommerce.backend.interfaces;

import java.io.IOException;
import java.util.List;

import com.ecommerce.backend.controllers.categories.CategoriesResponse;
import com.ecommerce.backend.controllers.categories.ReqCreateCategory;
import com.ecommerce.backend.controllers.categories.ReqUpdateCategory;

public interface ICategory {
    String create(ReqCreateCategory request) throws IOException;

    String update(ReqUpdateCategory request) throws IOException;

    String delete(Integer id);

    List<CategoriesResponse> get();

    CategoriesResponse getById(Integer id);

}
