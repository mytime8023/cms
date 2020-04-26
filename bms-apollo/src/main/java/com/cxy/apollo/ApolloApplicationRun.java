package com.cxy.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenxy
 * @date 2020/4/23 16:53
 * @desc this is description
 */
@SpringBootApplication
@EnableApolloConfig
public class ApolloApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(ApolloApplicationRun.class);
    }

}
