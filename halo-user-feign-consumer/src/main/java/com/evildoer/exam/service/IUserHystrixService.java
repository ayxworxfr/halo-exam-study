package com.evildoer.exam.service;

import com.evildoer.exam.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * openfeign高版本2.2.1中@FeignClient里面
 * 添加了新属性ContextId允许使用相同服务名
 * @description:
 * @author: evildoer
 * @datetime: 2021/1/27 19:15
 */
@Component
@FeignClient(contextId="Hystrix", value = "exam-user-provider", fallback = UserFallbackService.class)
public interface IUserHystrixService {

    @GetMapping("/user/hystrix/ok/{id}")
    public String userInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/user/hystrix/timeout/{id}")
    public String userInfo_Timeout(@PathVariable("id") Integer id);

}
