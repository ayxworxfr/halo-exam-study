package com.evildoer.exam.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.evildoer.exam.common.entity.Payment;
import com.evildoer.exam.common.response.CommonResult;
import com.evildoer.exam.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @author: evildoer
 * @datetime: 2021/2/2 16:46
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-service}")
    private String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    /**
     * fallback 处理Java异常(可以使用exceptionsToIgnore忽略Java异常)
     * blockHandler处理Sentinel配置异常
     * @author: evildoer
     * @datetime: 2021/2/2 18:47
     */
    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback",fallback ="handlerFallback")
    @SentinelResource(value = "fallback",fallback ="handlerFallback",blockHandler = "blockHandler")
    //@SentinelResource(value = "fallback",fallback ="handlerFallback",blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class,id);

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        }else if(result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }

        return  result;
    }


    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id,"null");
        return CommonResult.failed(payment, "异常handlerFallback，exception内容： " + e.getMessage());
    }


    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        Payment payment = new Payment(id,"null");
        return CommonResult.failed(payment, "blockHandler-sentinel 限流，BlockException： " + e.getMessage());
    }


    //======= OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
