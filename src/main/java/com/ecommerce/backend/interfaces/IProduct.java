package com.ecommerce.backend.interfaces;

import java.io.IOException;

import com.ecommerce.backend.controllers.product.CreateProductRequest;

public interface IProduct{
    String create(CreateProductRequest product) throws IOException;
    String update();
    String delete();
}
