/*
 * Seller.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.cifservice.seller.entity;

import com.b2b.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Seller.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "b2b_sellers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller extends BaseEntity {
    @Column(name = "seller_id")
    private String sellerId;

    @Column(name = "id_auto_increment")
    private String idAutoIncrement;
    private String name;
    private String status;

    @Column(name = "register_type")
    private String registerType;

    private String code;
}
