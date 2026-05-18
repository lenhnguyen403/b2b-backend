/*
 * User.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.entity;

import com.b2b.accountservice.account.enumeration.RoleType;
import com.b2b.accountservice.account.enumeration.UserStatus;
import com.b2b.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * User.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "b2b_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity implements UserDetails {
    @Column(unique = true, nullable = false)
    private String email;
    private String username;

    @JsonIgnore // bo qua password khi tra ve response User
    @Column(name = "password_hash")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    private String phone;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private boolean verified;

    @Column(name = "sign_in_count")
    private Integer signInCount;

    @Column(name = "failed_attempts")
    private Integer failedAttempts;

    @Column(name = "user_type")
    private RoleType userType;

    @Column(name = "organization_id")
    private UUID organizationId;

    @Column(name = "organization_code")
    private String organizationCode;

    @Column(name = "allow_notification")
    private Boolean allowNotification;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    // Khong can khai bao cac field audit: createdBy, createdDate, updatedBy, updatedDate

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == null) {
            return Collections.emptySet();
        }
        return Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + role.getName().name())
        );
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
