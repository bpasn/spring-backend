package com.firstApp.firstApp.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseException {
    private Boolean success = false;
    private HttpStatus status;
    private String message;
    public BaseException(){}
}
