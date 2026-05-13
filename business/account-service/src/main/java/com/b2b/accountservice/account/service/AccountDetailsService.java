/*
 * AccountDetailsService.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.service;

import com.b2b.accountservice.account.repository.UserRepository;
import com.b2b.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * AccountDetailsService.java
 *
 * @author Nguyen
 */
@RequiredArgsConstructor
@Service
public class AccountDetailsService extends UserDetailsServiceImpl {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
