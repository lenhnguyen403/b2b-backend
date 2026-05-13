/*
 * EurekaRegistryApplication.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaRegistryApplication.java
 *
 * @author Nguyen
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRegistryApplication.class, args);
    }
}
