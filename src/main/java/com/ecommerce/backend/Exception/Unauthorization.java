package com.ecommerce.backend.Exception;

import org.springframework.http.HttpStatus;

public class Unauthorization extends BaseException {

    public Unauthorization(String msg, HttpStatus status) {
        super(msg, status);
    }
}
