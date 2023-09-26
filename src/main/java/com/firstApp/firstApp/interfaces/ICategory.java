package com.firstApp.firstApp.interfaces;

import java.io.IOException;
import java.util.List;

import com.firstApp.firstApp.controllers.categories.CategoriesResponse;
import com.firstApp.firstApp.controllers.categories.ReqCreateCategory;
import com.firstApp.firstApp.controllers.categories.ReqUpdateCategory;

public interface ICategory {
    String create(ReqCreateCategory request) throws IOException;

    String update(ReqUpdateCategory request) throws IOException;

    String delete(Integer id);

    List<CategoriesResponse> get();

    CategoriesResponse getById(Integer id);

}
