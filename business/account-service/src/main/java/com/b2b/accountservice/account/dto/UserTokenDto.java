/*
 * UserTokenDto.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.dto;

import jakarta.validation.Valid;
import lombok.Data;

/**
 * UserTokenDto.java
 *
 * @author Nguyen
 */
@Data
public class UserTokenDto {
    @Valid
    private String refreshToken;
}
