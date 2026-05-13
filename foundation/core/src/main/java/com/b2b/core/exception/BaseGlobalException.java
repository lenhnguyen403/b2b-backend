/*
 * BaseGlobalException.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.exception;

import com.b2b.core.component.ResponseData;
import com.b2b.core.component.ResponseError;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * BaseGlobalException.java
 *
 * @author Nguyen
 */
@RestControllerAdvice
@Slf4j
public class BaseGlobalException {
    @ExceptionHandler(B2BException.class)
    public ResponseEntity<ResponseData<Object>> handleCoreException(
            B2BException ex, HttpServletRequest request) {
        ResponseError error = new ResponseError();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setCode("BAD_REQUEST");
        error.setDateTime(LocalDateTime.now().toString());
        error.setRequestId(request.getRequestURI());

        ResponseData<Object> response = new ResponseData<>();
        response.setData(error);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseData<Object>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((fieldError) -> {
            String field = ((FieldError) fieldError).getField();
            String message = fieldError.getDefaultMessage();
            errors.put(field, message);
        });

        ResponseData<Object> response = new ResponseData<>();
        response.setData(errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseData<Object>> handleException(Exception ex, HttpServletRequest request) {
        ResponseError error = new ResponseError();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(ex.getMessage());
        error.setCode("INTERNAL_SERVER_ERROR");
        error.setDateTime(LocalDateTime.now().toString());

        ResponseData<Object> response = new ResponseData<>();
        response.setData(error);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
