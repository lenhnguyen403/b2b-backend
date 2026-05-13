/*
 * Address.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.entity;

import com.b2b.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Address.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "b2b_addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    private String ward;
    private String district;
    private String city;
    private String country;

    @Column(name = "is_default")
    private boolean isDefault;

    private String type;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
