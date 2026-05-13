/*
 * ApiConstants.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.cifservice.buyer.constants;

/**
 * ApiConstants.java
 *
 * @author Nguyen
 */
public class ApiConstants {
    private ApiConstants() {
    }

    private static final String API = "/api/v1";

    public static class Buyer {
        private Buyer() {
        }

        public static final String PREFIX = API + "/buyers";
    }
}
