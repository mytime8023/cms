package com.cxy.bms.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenxy
 * @date 2020/4/23 9:29
 * @desc this is description
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启nacos注册中心客户端
public class BmsApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(BmsApplicationRun.class);
    }
}
