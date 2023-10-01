package com.ecommerce.backend.interfaces;

import java.io.IOException;

import com.ecommerce.backend.controllers.product.ReqCreateProduct;

public interface IProduct{
    String create(ReqCreateProduct product) throws IOException;
    String update();
    String delete();
}
