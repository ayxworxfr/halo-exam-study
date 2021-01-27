package com.evildoer.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: evildoer
 * @datetime: 2021/1/27 16:51
 */
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UserFeignConsumer {
    public static void main(String[] args) {
        SpringApplication.run(UserFeignConsumer.class, args);
    }
}
