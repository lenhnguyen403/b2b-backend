/*
 * BaseResponsePageDto.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * BaseResponsePageDto.java
 *
 * @author Nguyen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseResponsePageDto {
    private Long totalPage;
    private Long totalResult;
    private Integer page;
    private Integer perPage;
}
