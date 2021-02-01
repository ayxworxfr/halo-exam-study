package com.evildoer.exam.controller;

import com.evildoer.exam.common.entity.User;
import com.evildoer.exam.common.response.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NooYoo.
 * Created on 2019/7/29 下午9:31.
 * Description:
 */
@Slf4j
@RestController
@Api(tags = "user-接口文档")
public class TestController {


    @ApiOperation("根据用户名查询用户")
    @GetMapping("/getByUsername")
    public CommonResult<User> getByUsername(@RequestParam String username) {
        User user = new User();
        user.setUserName("test");
        return CommonResult.success(user, "success");
    }
}