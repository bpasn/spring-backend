package com.firstApp.firstApp.interfaces;

import java.io.IOException;
import java.util.List;

import com.firstApp.firstApp.controllers.categories.CategoriesResponse;
import com.firstApp.firstApp.controllers.categories.ReqCreateCategory;


public interface ICategory  {
    String create(ReqCreateCategory request) throws IOException;
    String update(Integer id);
    String delete(Integer id);
    List<CategoriesResponse> get();
}
