/*
 * Buyer.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.cifservice.buyer.entity;

import com.b2b.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Buyer.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "b2b_buyers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buyer extends BaseEntity {
    @Column(name = "buyer_id")
    private String buyerId;

    @Column(name = "id_auto_increment")
    private String idAutoIncrement;
    private String name;
    private String status;

    @Column(name = "register_type")
    private String registerType;

    private String code;
}
