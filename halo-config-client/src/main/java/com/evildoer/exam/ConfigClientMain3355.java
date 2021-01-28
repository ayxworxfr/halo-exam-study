package com.evildoer.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: evildoer
 * @datetime: 2021/1/28 14:03
 */
//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {
    /**
     * @description: 动态刷新 curl -X POST "http://localhost:3355/actuator/refresh"
     * @author: evildoer
     * @datetime: 2021/1/28 14:51
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
