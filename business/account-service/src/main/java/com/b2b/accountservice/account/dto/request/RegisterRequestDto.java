/*
 * RegisterRequestDto.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.dto.request;

import com.b2b.accountservice.account.enumeration.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RegisterRequestDto.java
 *
 * @author Nguyen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {
    @NotBlank
    @Email(message = "Email has to be valid")
    private String email;

    @NotBlank
    private String fullName;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 character")
    private String password;

    @NotBlank
    private String confirmPassword;

    private RoleType registerType;
}
