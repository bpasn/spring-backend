package com.firstApp.firstApp.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class HandleError{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseValidate> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, List<String>> body = new HashMap<>();
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

   @ExceptionHandler(AuthenticationException.class)
   @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ExceptionBase> handleMethodException(AuthenticationException ex) {
       ExceptionBase response = new ExceptionBase();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(HibernateException.class)
    public ResponseEntity<ExceptionBase> handleMethodException(HibernateException ex) {
       ExceptionBase response = new ExceptionBase();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionBase> handleMethodException(Exception ex) {
        log.error(ex);
       ExceptionBase response = new ExceptionBase();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionBase> handleMethodException(AccessDeniedException ex){
        ExceptionBase response = new ExceptionBase();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @Data
    public static class ExceptionResponseValidate {
        private List<Map<String, String>> errors;
        private Boolean success;
    }

    @Data
    public static class ExceptionBase {
        private Boolean success;
        private String message;
    }

}

