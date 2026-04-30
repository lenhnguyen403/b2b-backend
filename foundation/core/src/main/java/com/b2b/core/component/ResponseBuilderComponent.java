/*
 * ResponseBuilderComponent.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.component;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * ResponseBuilderComponent.java
 *
 * @author Nguyen
 */
@Component
public class ResponseBuilderComponent {
    public <T> ResponseData<T> buildResponse(T data, HttpServletRequest httpServletRequest) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setData(data);

        return responseData;
    }
}
