package com.firstApp.firstApp.interfaces;

import java.io.IOException;

import com.firstApp.firstApp.controllers.categories.ReqCreateCategory;


public interface ICategory  {
    String create(ReqCreateCategory request) throws IOException;
    String update(Integer id);
    String delete(Integer id);
}
