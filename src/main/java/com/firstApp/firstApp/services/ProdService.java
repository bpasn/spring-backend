package com.firstApp.firstApp.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.firstApp.firstApp.controllers.product.ReqCreate;
import com.firstApp.firstApp.interfaces.IProduct;

@Service
public class ProdService implements IProduct {

    private final Helper helper;

    public ProdService(Helper helper) {
        this.helper = helper;
    }

    @Override
    public String create(ReqCreate product) throws IOException {
       return "Create Product Successfully";
    }

    @Override
    public String update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
