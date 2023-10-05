package com.ecommerce.backend.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
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
