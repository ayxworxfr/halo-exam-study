package com.evildoer.exam.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description: Sentinel测试类
 * @author: evildoer
 * @datetime: 2021/2/1 14:39
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        // 暂停毫秒(线程数阈值)
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "--------testB";
    }


    @GetMapping("/testD")
    public String testD() {
        // 暂停几秒
        //try {
        //    TimeUnit.SECONDS.sleep(1);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //log.info("testD 测试RT");

        log.info("testD 异常比例");
        int age = 10 / 0;
        return "--------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 异常比例");
        int age = 10 / 0;
        return "--------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p1", required = false) String p2) {
        return "--------testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exception){
        return "--------dealTestHotKey, o(╥﹏╥)o";
    }
}
