package com.evildoer.exam.controller;

import com.evildoer.exam.common.entity.User;
import com.evildoer.exam.common.response.CommonPage;
import com.evildoer.exam.common.response.CommonResult;
import com.evildoer.exam.model.form.UserQuery;
import com.evildoer.exam.model.vo.UserVo;
import com.evildoer.exam.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description: 用户服务接口
 * @author: evildoer
 * @datetime: 2021/1/27 11:15
 */
@Slf4j
@RestController
@RequestMapping
public class UserController {

    @Value("${server.port}")
    private String serverPort;

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * @description: 返回用户列表
     * @param query 查询参数
     * @return: org.springframework.web.servlet.function.CommonResult
     * @author: evildoer
     * @datetime: 2021/1/27 11:27
     */
    @GetMapping("/user/list")
    public CommonResult<List<User>> list(UserQuery query) {
        // todo: pagebyquery
        return CommonResult.success("success");
        //return CommonResult.success(CommonPage.restPage(serService.pageByQuery(query)));
    }

    /**
     * @description: 添加用户
     * @param user 用户
     * @return: org.springframework.web.servlet.function.CommonResult
     * @author: evildoer
     * @datetime: 2021/1/27 11:27
     */
    @PostMapping("/user/add")
    public CommonResult add(@RequestBody User user) {
        boolean result = this.userService.save(user);
        if (result) {
            return CommonResult.success("添加成功");
        } else {
            return CommonResult.failed("添加失败");
        }
    }

    /**
     * @description: 通过id查找用户
     * @param id 用户id
     * @return: org.springframework.web.servlet.function.CommonResult
     * @author: evildoer
     * @datetime: 2021/1/27 11:29
     */
    @GetMapping("/user/{id:\\d+}")
    public CommonResult<User> getById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (null != user) {
            user.setPassword("");
            return CommonResult.success(user, "serverPort: " + serverPort);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * @description: 通过id删除用户
     * @param userId 用户id
     * @return: org.springframework.web.servlet.function.CommonResult
     * @author: evildoer
     * @datetime: 2021/1/27 11:28
     */
    @DeleteMapping("/user/{user_id:\\d+}")
    public CommonResult delete(@PathVariable("user_id") Long userId) {
        boolean result = userService.removeById(userId);
        if (result) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.failed("删除失败");
        }
    }

    /**
     * @description: 更新用户
     * @param user
     * @return: org.springframework.web.servlet.function.CommonResult
     * @author: evildoer
     * @datetime: 2021/1/27 11:29
     */
    @PutMapping("/user")
    public CommonResult update(@NotNull @RequestBody User user) {
        boolean result = this.userService.saveOrUpdate(user);
        if (result) {
            return CommonResult.success("添加成功");
        } else {
            return CommonResult.failed("添加失败");
        }
    }


    /*--------------- 测试 ---------------*/
    /**
     * @description: 服务超时测试
     * @return: java.lang.String
     * @author: evildoer
     * @datetime: 2021/1/27 19:23
     */
    @GetMapping(value = "/user/timeout")
    public String userFeignTimeout() {
        //openfeign-ribbon 服务端需要3S
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/user/hystrix/ok/{id}")
    public String userInfo_OK(@PathVariable("id") Integer id) {
        String result = userService.userInfo_OK(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/user/hystrix/timeout/{id}")
    public String userInfo_Timeout(@PathVariable("id") Integer id) {
        String result = userService.userInfo_Timeout(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/user/circuit/{id}")
    public String userCircuitBreaker(@PathVariable("id") Integer id) {
        String result = userService.userCircuitBreaker(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/user/zipkin")
    public String userZipkin(){
        return "Hi I am user-zipkin server fall back, O(∩_∩)O哈哈~";
    }
}
