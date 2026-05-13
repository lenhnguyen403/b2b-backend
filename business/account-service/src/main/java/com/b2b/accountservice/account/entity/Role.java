/*
 * Role.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.entity;

import com.b2b.accountservice.account.enumeration.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


/**
 * Role.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "b2b_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keycloak_role_id")
    private String keycloakRoleId;

    @Enumerated(EnumType.STRING)
    private RoleType name;

    private List<String> scope;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "role")   // map voi ten field trong User
    List<User> users = new ArrayList<>();
}
