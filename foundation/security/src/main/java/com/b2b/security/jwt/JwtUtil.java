/*
 * JwtUtil.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * JwtUtil.java
 *
 * @author Nguyen
 */
@Component
public abstract class JwtUtil {

    public abstract String getSubject(String token);

    public abstract boolean isTokenValid(String token, UserDetails username);
}
