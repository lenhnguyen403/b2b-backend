/*
 * AuthServiceImpl.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.service.impl;

import com.b2b.accountservice.account.dto.request.LoginRequestDto;
import com.b2b.accountservice.account.dto.request.RegisterRequestDto;
import com.b2b.accountservice.account.dto.response.LoginResponse;
import com.b2b.accountservice.account.dto.response.RegisterResponse;
import com.b2b.accountservice.account.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * AuthServiceImpl.java
 *
 * @author Nguyen
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginResponse login(LoginRequestDto loginRequest) {
        return null;
    }

    @Override
    public RegisterResponse register(RegisterRequestDto registerRequest) {
        return null;
    }

    @Override
    public void refreshToken(String refreshToken) {

    }
}
