/*
 * BaseRequestPageDto.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * BaseRequestPageDto.java
 *
 * @author Nguyen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseRequestPageDto {
    private Integer limit;
    private Integer pageNo;
    private String sortBy;
    private String sortDirection;
}
