package com.evildoer.exam.service;

import com.evildoer.exam.common.entity.User;
import com.evildoer.exam.common.response.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: evildoer
 * @datetime: 2021/1/27 16:54
 */
@Component
@FeignClient(contextId="User", value="halo-user-provider")
public interface UserFeignService {

    @GetMapping(value="/user/{id:\\d+}")
    //public CommonResult<User> getById(@PathVariable("id") Long id);
    public CommonResult<User> getById(@RequestParam("id") Long id);


    @GetMapping(value = "/user/timeout")
    public String userFeignTimeout();
}
