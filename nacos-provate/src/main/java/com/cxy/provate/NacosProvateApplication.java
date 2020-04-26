package com.cxy.provate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxy
 * @date 2020/4/21 17:37
 * @desc this is description
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvateApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvateApplication.class);
    }

    @Value("${spring.dataSource.url}")
    String url;

    @RequestMapping("/11111")
    public String test(){
        return url;
    }

}
