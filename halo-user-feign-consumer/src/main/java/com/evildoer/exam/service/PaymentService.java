package com.evildoer.exam.service;

import com.evildoer.exam.common.entity.Payment;
import com.evildoer.exam.common.response.CommonResult;
import com.evildoer.exam.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author: evildoer
 * @datetime: 2021/2/2 16:46
 */
@FeignClient(value = "halo-user-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
