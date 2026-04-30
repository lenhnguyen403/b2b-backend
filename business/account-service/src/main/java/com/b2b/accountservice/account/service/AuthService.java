/*
 * AuthService.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.service;

import com.b2b.accountservice.account.dto.request.LoginRequestDto;
import com.b2b.accountservice.account.dto.request.RegisterRequestDto;
import com.b2b.accountservice.account.dto.response.LoginResponse;
import com.b2b.accountservice.account.dto.response.RegisterResponse;
import jakarta.validation.Valid;

/**
 * AuthService.java
 *
 * @author Nguyen
 */
public interface AuthService {
    LoginResponse login(@Valid LoginRequestDto loginRequest);

    RegisterResponse register(@Valid RegisterRequestDto registerRequest);

    void refreshToken(@Valid String refreshToken);
}
