/*
 * OtpUtil.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * OtpUtil.java
 *
 * @author Nguyen
 */
@Component
public class OtpUtil {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final int OTP_LENGTH = 6;

    public static String generateOtpCode() {
        int otp = secureRandom.nextInt((int) Math.pow(10, OTP_LENGTH));

        return String.format("%0" + OTP_LENGTH + "d", otp);
    }
}
