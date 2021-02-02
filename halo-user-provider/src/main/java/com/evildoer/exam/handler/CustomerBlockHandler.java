package com.evildoer.exam.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.evildoer.exam.common.entity.User;
import com.evildoer.exam.common.response.CommonResult;


public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        User user = new User();
        user.setUserName("handlerException");
        return  CommonResult.success(user,"按照客户自定义的Glogal 全局异常处理 ---- 1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        User user = new User();
        user.setUserName("handlerException2");
        return  CommonResult.success(user,"按照客户自定义的Glogal 全局异常处理 ---- 2");
    }
}
