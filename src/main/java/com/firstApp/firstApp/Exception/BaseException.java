package com.firstApp.firstApp.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseException extends RuntimeException {
    private Boolean success = false;
    private HttpStatus status;
    public BaseException(){}
    public BaseException(String msg){
        super(msg);
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        setSuccess(false);
    }
    public BaseException(String msg,HttpStatus status){
        super(msg);
        setStatus(status);
        setSuccess(false);
    }
}
