package com.evildoer.exam.service.impl;

import com.evildoer.exam.common.entity.Payment;
import com.evildoer.exam.common.response.CommonResult;
import com.evildoer.exam.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author: evildoer
 * @datetime: 2021/2/2 16:46
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return CommonResult.failed(new Payment(id,"ErrorSerial"), "服务降级返回，---PaymentFallbackService");
    }
}
