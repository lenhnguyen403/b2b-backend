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
import com.b2b.accountservice.account.entity.Role;
import com.b2b.accountservice.account.entity.User;
import com.b2b.accountservice.account.enumeration.RoleType;
import com.b2b.accountservice.account.repository.RoleRepository;
import com.b2b.accountservice.account.repository.UserRepository;
import com.b2b.accountservice.account.service.AuthService;
import com.b2b.accountservice.utils.AccountUtil;
import com.b2b.core.exception.B2BException;
import com.b2b.core.utils.OtpUtil;
import com.b2b.mail.service.EmailService;
import jakarta.mail.MessagingException;
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
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccountUtil accountUtil;
    private final OtpUtil otpUtil;
    private final EmailService emailService;

    @Override
    public LoginResponse login(LoginRequestDto loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new B2BException("Invalid email or password"));

        if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new B2BException("Invalid password");
        }

        LoginResponse response = LoginResponse.builder()
                .accessToken(accountUtil.generateToken(user))
                .refreshToken(accountUtil.generateRefreshToken(user))
                .tokenType("Bearer")
                .user(user)
                .build();

        return response;
    }

    @Override
    public RegisterResponse register(RegisterRequestDto registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            throw new B2BException("Passwords don't match");
        }

        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new B2BException("This email is already registered");
        }

        Role role = roleRepository.findByName(registerRequest.getRegisterType())
                .orElseThrow(() -> new B2BException("Role not found"));

        User user = User.builder()
                .email(registerRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(registerRequest.getPassword()))
                .fullName(registerRequest.getFullName())
                .role(role)
                .build();

        User savedUser = userRepository.save(user);

        RegisterResponse response = RegisterResponse.builder()
                .user(savedUser)
                .build();

        // Generate OTP
        String otp = otpUtil.generateOtpCode();

        // Luu OTP vao DB/Redis

        // Gui OTP ve mail
        try {
            emailService.sendOTP(registerRequest.getEmail(), otp);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

        return response;
    }

    @Override
    public void refreshToken(String refreshToken) {

    }
}
