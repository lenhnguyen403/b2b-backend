/*
 * ResponseError.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.component;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * ResponseError.java
 *
 * @author Nguyen
 */
@Data
public class ResponseError {
    private @NotNull int status = 200;
    private String code;
    private String requestId;
    private String message;
    private String dateTime;
}
