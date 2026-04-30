/*
 * B2BCoreException.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.exception;

/**
 * B2BCoreException.java
 *
 * @author Nguyen
 */
public class B2BCoreException extends RuntimeException {
    public B2BCoreException() {
    }

    public B2BCoreException(String message) {
        super(message);
    }
}
