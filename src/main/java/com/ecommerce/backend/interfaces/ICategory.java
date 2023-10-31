package com.ecommerce.backend.interfaces;

import java.io.IOException;
import java.util.List;

import com.ecommerce.backend.controllers.categories.CategoriesDTO;
import com.ecommerce.backend.controllers.categories.ReqCreateCategory;

public interface ICategory {
    String create(ReqCreateCategory request) throws IOException;
//
//    String update(ReqUpdateCategory request) throws IOException;

//    String delete(Integer id);

    List<CategoriesDTO> getToDTO();

//    CategoriesResponse getById(Integer id);

}
