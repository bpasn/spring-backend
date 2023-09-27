package com.ecommerce.backend.interfaces;

import java.io.IOException;

import com.ecommerce.backend.controllers.product.ReqCreate;

public interface IProduct{
    String create(ReqCreate product) throws IOException;
    String update();
    String delete();
}
