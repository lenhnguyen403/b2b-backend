/*
 * ResponseData.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

/**
 * ResponseData.java
 *
 * @author Nguyen
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {
    private ResponseError error;

    @JsonUnwrapped
    private T data;
}
