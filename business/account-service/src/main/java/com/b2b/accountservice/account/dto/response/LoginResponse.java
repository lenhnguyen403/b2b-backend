/*
 * LoginResponse.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.dto.response;

import com.b2b.accountservice.account.entity.User;
import lombok.Builder;
import lombok.Data;

/**
 * LoginResponse.java
 *
 * @author Nguyen
 */
@Data
@Builder
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;

    private User user;
}
