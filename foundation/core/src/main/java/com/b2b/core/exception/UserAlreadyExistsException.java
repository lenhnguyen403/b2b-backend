/*
 * UserAlreadyExistsException.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.exception;

/**
 * UserAlreadyExistsException.java
 *
 * @author Nguyen
 */
public class UserAlreadyExistsException extends B2BCoreException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
