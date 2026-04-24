/*
 * AuthController.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.controller;

import com.b2b.accountservice.account.constants.ApiConstants;
import com.b2b.accountservice.account.dto.UserTokenDto;
import com.b2b.accountservice.account.dto.request.LoginRequestDto;
import com.b2b.accountservice.account.dto.request.RegisterRequestDto;
import com.b2b.accountservice.account.dto.response.LoginResponse;
import com.b2b.accountservice.account.dto.response.RegisterResponse;
import com.b2b.accountservice.account.service.AuthService;
import com.b2b.core.component.B2BResponseEntity;
import com.b2b.core.component.ResponseBuilderComponent;
import com.b2b.core.component.ResponseData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController.java
 *
 * @author Nguyen
 */
@RestController
@RequestMapping(ApiConstants.Auth.PREFIX)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final ResponseBuilderComponent builderComponent;

    @PostMapping(ApiConstants.UserEntity.REGISTER)
    public B2BResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequestDto registerRequest, HttpServletRequest request) {
        RegisterResponse dto = authService.register(registerRequest);
        ResponseData<RegisterResponse> responseData = builderComponent.buildResponse(dto, request);
        return new B2BResponseEntity<>(responseData);
    }

    @PostMapping(ApiConstants.UserEntity.LOGIN)
    public B2BResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequestDto loginRequest, HttpServletRequest request) {
        LoginResponse dto = authService.login(loginRequest);
        ResponseData<LoginResponse> responseData = builderComponent.buildResponse(dto, request);
        return new B2BResponseEntity<>(responseData);
    }

    @PostMapping(ApiConstants.UserEntity.LOGOUT)
    public B2BResponseEntity<Void> logout(@Valid @RequestBody UserTokenDto dto, HttpServletRequest request) {
        authService.refreshToken(dto.getRefreshToken());
        return new B2BResponseEntity<>(builderComponent.buildResponse(null, request));
    }
}
