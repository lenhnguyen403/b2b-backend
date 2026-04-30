/*
 * B2BResponseEntity.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.component;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * B2BResponseEntity.java
 *
 * @author Nguyen
 */
public class B2BResponseEntity<T> extends ResponseEntity<ResponseData<T>> {
    public B2BResponseEntity() {
        super(HttpStatus.OK);
    }

    public B2BResponseEntity(ResponseData<T> body) {
        super(body, HttpStatus.OK);
    }

    public B2BResponseEntity(MultiValueMap<String, String> headers) {
        super(headers, HttpStatus.OK);
    }

    public B2BResponseEntity(ResponseData<T> body, MultiValueMap<String, String> headers) {
        super(body, headers, HttpStatus.OK);
    }

    public B2BResponseEntity(ResponseData<T> body, HttpStatus httpStatus) {
        super(body, httpStatus);
    }

}
