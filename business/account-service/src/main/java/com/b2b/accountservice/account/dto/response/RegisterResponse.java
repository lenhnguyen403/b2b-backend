/*
 * RegisterResponse.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.dto.response;

import com.b2b.accountservice.account.entity.User;
import lombok.Builder;
import lombok.Data;

/**
 * RegisterResponse.java
 *
 * @author Nguyen
 */
@Data
@Builder
public class RegisterResponse {
    private User user;
}
