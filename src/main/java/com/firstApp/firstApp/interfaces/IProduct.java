package com.firstApp.firstApp.interfaces;

import java.io.IOException;

import com.firstApp.firstApp.controllers.product.ReqCreate;

public interface IProduct {
    String create(ReqCreate product) throws IOException;
    String update();
    String delete();
}
