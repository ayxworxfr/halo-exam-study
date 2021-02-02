package com.evildoer.exam.controller;

import com.evildoer.exam.common.entity.User;
import com.evildoer.exam.common.response.CommonResult;
import com.evildoer.exam.service.IUserHystrixService;
import com.evildoer.exam.service.UserFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: evildoer
 * @datetime: 2021/1/27 17:01
 */
@Slf4j
@RestController
public class UserFeignController {
    @Resource
    private UserFeignService userFeignService;

    @Resource
    private IUserHystrixService userHystrixService;

    @GetMapping("/user/{id:\\d+}")
    public CommonResult<User> getById(@PathVariable("id") Long id){
        return userFeignService.getById(id);
    }


    @GetMapping(value = "/user/timeout")
    public String userFeignTimeout() {
        //openfeign-ribbon 客户端默认等待1S
        return  userFeignService.userFeignTimeout();
    }

    //@HystrixCommand
    @GetMapping("/user/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "userInfo_TimeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String userInfo_Timeout(@PathVariable("id") Integer id){
        String result = userHystrixService.userInfo_Timeout(id);
        return  result;
    }

    public String userInfo_TimeoutFallbackMethod(Integer id) {
        return "系统繁忙，请10秒钟后重新尝试o(╥﹏╥)o";
    }


    @GetMapping("/user/hystrix/ok/{id}")
    public String userInfo_OK(@PathVariable("id") Integer id){
        String result = userHystrixService.userInfo_OK(id);
        return  result;
    }

    public String userInfo_TimeoutFallbackMethod() {
        return "/(ToT)/我是消费者80，调用8001支付系统繁忙，请10秒钟后重新尝试、\t";
    }

    // 下面是全局fallback方法
    public String userInfo_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试， /(ToT)/";
    }

}

