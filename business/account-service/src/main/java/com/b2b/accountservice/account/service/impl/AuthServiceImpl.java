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
import com.b2b.accountservice.account.entity.User;
import com.b2b.accountservice.account.repository.UserRepository;
import com.b2b.accountservice.account.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public LoginResponse login(LoginRequestDto loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        LoginResponse response = LoginResponse.builder()
                .accessToken("")
                .refreshToken("")
                .tokenType("")
                .build();

        return response;
    }

    @Override
    public RegisterResponse register(RegisterRequestDto registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            throw new RuntimeException("Passwords don't match");
        }

        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new RuntimeException("This email is already registered");
        }

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
        user.setFullName(registerRequest.getFullName());

        User savedUser = userRepository.save(user);

        RegisterResponse response = RegisterResponse.builder()
                .user(savedUser)
                .build();

        return response;
    }

    @Override
    public void refreshToken(String refreshToken) {

    }
}
