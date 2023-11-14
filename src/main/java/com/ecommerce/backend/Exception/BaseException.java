package com.ecommerce.backend.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private Boolean success = false;
    private int code;
    public BaseException(String msg,HttpStatus status){
        super(msg);
        setSuccess(false);
        setCode(status.value());
    }

}
