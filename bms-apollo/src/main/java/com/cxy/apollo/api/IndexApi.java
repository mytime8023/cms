package com.cxy.apollo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxy
 * @date 2020/4/23 16:54
 * @desc this is description
 */
@RestController
@RequestMapping("/index")
public class IndexApi {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @RequestMapping("/driver")
    public String driver(){
        return driver;
    }

}
