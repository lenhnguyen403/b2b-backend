/*
 * RoleRepository.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.repository;

import com.b2b.accountservice.account.entity.Role;
import com.b2b.accountservice.account.enumeration.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * RoleRepository.java
 *
 * @author Nguyen
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
