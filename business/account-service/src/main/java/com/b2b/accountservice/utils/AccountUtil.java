/*
 * AccountUtil.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.utils;

import com.b2b.accountservice.account.entity.User;
import com.b2b.security.jwt.JwtUtil;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * AccountUtil.java
 *
 * @author Nguyen
 */
@Component
@Slf4j
public class AccountUtil extends JwtUtil {
    @Value("${application.jwt.secret}")
    private String secret;

    @Value("${application.jwt.expiredTime}")
    private Long expiredTime;

    @Value("${application.jwt.refreshExpiredTime}")
    private Long refreshExpiredTime;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("roles", user.getRole());

        return createToken(claims, user.getUsername(), expiredTime);
    }

    public String generateRefreshToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());

        return createToken(claims, user.getUsername(), refreshExpiredTime);
    }

    private String createToken(Map<String, Object> claims, String subject, Long expiredTime) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public String getSubject(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public String getUserId(String token) {
        return extractClaims(token, claims -> claims.get("userId").toString());
    }

    public Date getExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getSubject(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
