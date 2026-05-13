/*
 * UserController.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.controller;

import com.b2b.accountservice.account.constants.ApiConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController.java
 *
 * @author Nguyen
 */
@RestController
@RequestMapping(ApiConstants.UserEntity.PREFIX)
@RequiredArgsConstructor
public class UserController {
    
}
