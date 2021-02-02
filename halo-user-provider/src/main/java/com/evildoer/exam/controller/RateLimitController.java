package com.evildoer.exam.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.evildoer.exam.common.entity.User;
import com.evildoer.exam.common.response.CommonResult;
import com.evildoer.exam.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        User user = new User();
        user.setUserName("byResource");
        return  CommonResult.success(user,"按照资源名称限流测试");
    }

    public CommonResult handleException(BlockException exception) {
        return  CommonResult.failed(exception.getClass().getCanonicalName() + " 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        User user = new User();
        user.setUserName("byUrl");
        return  CommonResult.success(user,"按照byUrl限流测试");
    }

    //CustomerBlockHandler
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        User user = new User();
        user.setUserName("customerBlockHandler");
        return  CommonResult.success(user,"按照客户自定义限流测试");
    }
}
