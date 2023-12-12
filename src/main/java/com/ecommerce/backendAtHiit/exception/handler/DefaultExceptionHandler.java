package com.ecommerce.backendAtHiit.exception.handler;

import com.ecommerce.backendAtHiit.exception.ExceptionResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
        ExceptionResponse<Map<String,String>> response = new ExceptionResponse<>();
        response.setTimeStamp(Instant.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Validation Error");
        List<FieldError> fieldErrorList = exception.getFieldErrors();
        List<Map<String,String>> list = new ArrayList<>();
        for (FieldError fieldError: fieldErrorList) {
            Map<String,String> err = new HashMap<>();
            err.put("field", fieldError.getField());
            err.put("message", fieldError.getDefaultMessage());
            list.add(err);
        }
        response.setData(list);
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(UserAuthenticationException.class)
    public ResponseEntity<?> UserAuthenticationExceptionHandler(UserAuthenticationException exception){
        ExceptionResponse<Map<String,String>> response = new ExceptionResponse<>();
        response.setMessage("Authentication Error");
        response.setTimeStamp(Instant.now());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setData(null);
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
