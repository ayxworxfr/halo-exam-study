package com.evildoer.exam.service.impl;

import com.evildoer.exam.service.IUserHystrixService;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @author: evildoer
 * @datetime: 2021/1/27 19:15
 */
@Component
public class UserFallbackService implements IUserHystrixService {

    @Override
    public String userInfo_OK(Integer id) {
        return "----userFallbackService fall back userInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String userInfo_Timeout(Integer id) {
        return "----userFallbackService fall back userInfo_Timeout,o(╥﹏╥)o";
    }
}
