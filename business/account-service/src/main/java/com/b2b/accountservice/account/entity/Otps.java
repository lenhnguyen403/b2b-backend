/*
 * Otps.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.entity;

import com.b2b.accountservice.account.enumeration.OtpStatus;
import com.b2b.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Otps.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "b2b_otp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Otps extends BaseEntity {
    private String email;
    private String phone;

    @Column(name = "otp_code")
    private String otpCode;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "verify_url")
    private String verifyUrl;

    @Enumerated(EnumType.STRING)
    private OtpStatus status;

    @Column(name = "failedAttempts")
    private Integer failedAttempts;

    @Column(name = "failed_otp")
    private Integer failedOtp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
