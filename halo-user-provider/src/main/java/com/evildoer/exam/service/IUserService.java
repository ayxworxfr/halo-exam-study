package com.evildoer.exam.service;


import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evildoer.exam.common.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户管理 服务类
 * </p>
 *
 * @author evildoer
 * @since 2021-01-26
 */
public interface IUserService extends IService<User> {

    /*--------------- 测试 ---------------*/
    public String userInfo_OK(Integer id);
    
    public String userInfo_Timeout(Integer id) ;

    public String userInfo_TimeoutHandler(Integer id);
    
    public String userCircuitBreaker(@PathVariable("id") Integer id);

    public String userCircuitBreaker_fallback(@PathVariable("id") Integer id);
}
