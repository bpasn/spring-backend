package com.ecommerce.backend.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class HandleErrorControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseValidate> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ExceptionResponseValidate response = new ExceptionResponseValidate();
        response.setSuccess(false);
        List<Map<String, String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("field", e.getField());
                    map.put("message", e.getDefaultMessage());
                    return map;
                })
                .collect(Collectors.toList());

        response.setErrors(errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(HibernateException.class)
//    public ResponseEntity<ExceptionBase> handleMethodException(HibernateException ex) {
//        ExceptionBase response = new ExceptionBase();
//        response.setMessage(ex.getMessage());
//        response.setSuccess(false);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<ExceptionBase> handleMethodException(HttpRequestMethodNotSupportedException ex) {
//        ExceptionBase response = new ExceptionBase();
//        response.setMessage(ex.getMessage());
//        response.setSuccess(false);
//        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
//    }

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExceptionBase> handleMethodException(BaseException ex) {
        ExceptionBase response = new ExceptionBase();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        response.setCode(ex.getCode());
        if(ex.getCode() == 401){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        return ResponseEntity.ok(response);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionBase> handleMethodException(Exception ex) {
        ExceptionBase response = new ExceptionBase();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    @ExceptionHandler(Unauthorization.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ExceptionBase> handleAuthorization(Unauthorization ex) {
        ExceptionBase response = new ExceptionBase();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        response.setCode(ex.getCode());
        return ResponseEntity.ok(response);
    }


    @Data
    public static class ExceptionResponseValidate {
        private List<Map<String, String>> errors;
        private Boolean success;
    }

    @Data
    public static class ExceptionBase {
        private Boolean success;
        private int code;
        private String message;
    }

}
