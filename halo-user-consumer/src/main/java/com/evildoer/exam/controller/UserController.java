package com.evildoer.exam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: evildoer
 * @datetime: 2021/1/27 16:05
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/user/{id}")
    public String userInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverURL + "/user/" + id, String.class);
    }
}
