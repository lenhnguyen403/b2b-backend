/*
 * ApiConstants.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.accountservice.account.constants;

/**
 * ApiConstants.java
 *
 * @author Nguyen
 */
public class ApiConstants {
    private ApiConstants() {
    }

    public static final String API = "/api/v1";

    public static class Auth {
        private Auth() {
        }

        public static final String PREFIX = API + "/auth";
    }

    public static class UserEntity {
        private UserEntity() {
        }

        public static final String PREFIX = API + "/users";

        public static final String LOGIN = "/login";
        public static final String LOGIN_ADMIN = "login-admin";
        public static final String LOGOUT = "/logout";
        public static final String CHANGE_PASSWORD = "/change-password";
        public static final String FORGOT_PASSWORD = "/forgot-password";
        public static final String REFRESH_TOKEN = "/refresh-token";
        public static final String CONFIRM_OTP = "/confirm-otp";
        public static final String CHANGE_PASSWORD_OTP = "/otp/change-password";
        public static final String REGISTER = "/register";
    }
}
