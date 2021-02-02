package com.evildoer.exam.controller;

import com.evildoer.exam.common.entity.Payment;
import com.evildoer.exam.common.response.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: evildoer
 * @datetime: 2021/2/2 15:00
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private  String serverPort;

    public static HashMap<Long, Payment > map = new HashMap<>();
    static {
        map.put(1L,new Payment(1L,"1111"));
        map.put(2L,new Payment(2L,"2222"));
        map.put(3L,new Payment(3L,"3333"));
    }


    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        return CommonResult.success(payment, "from mysql,serverPort: " + serverPort);
    }
}
