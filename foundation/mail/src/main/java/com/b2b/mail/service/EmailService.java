/*
 * EmailService.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.mail.service;

import jakarta.mail.MessagingException;

/**
 * EmailService.java
 *
 * @author Nguyen
 */
public interface EmailService {
    void sendOTP(String email, String otp) throws MessagingException;
}
