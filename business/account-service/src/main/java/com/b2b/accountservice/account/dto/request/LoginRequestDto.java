/*
 * LoginRequestDto.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LoginRequestDto.java
 *
 * @author Nguyen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {
    private String email;
    private String password;
}
