package com.cxy.bms.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenxy
 * @date 2020/4/28 11:04
 * @desc this is description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BmsSecurityJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(BmsSecurityJwtApplication.class);
    }
}
