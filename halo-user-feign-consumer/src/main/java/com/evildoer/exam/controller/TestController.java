package com.evildoer.exam.controller;

import com.evildoer.exam.common.entity.User;
import com.evildoer.exam.common.response.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        //User user = userService.getByUsername(username);
        User user = new User();
        user.setUserName("test");
        return CommonResult.success(user, "success");
    }
    @ApiOperation(value = "user-测试接口", notes = "测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", paramType = "path", value = "数字a", required = true, dataType = "path"),
            @ApiImplicitParam(name = "b", paramType = "path", value = "数字b", required = true, dataType = "path")
    })
    @GetMapping("/user/test/{a}/{b}")
    public Integer get(@PathVariable Integer a, @PathVariable Integer b) {
        log.info("user文档访问");
        return a + b;
    }
}