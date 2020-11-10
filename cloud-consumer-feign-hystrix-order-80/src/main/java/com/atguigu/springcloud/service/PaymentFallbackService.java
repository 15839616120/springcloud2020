package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wuyz1
 * 解耦后 服务降级的统一方法
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo(Integer id) {
        return "PaymentHystrixService fall back paymentInfo";
    }

    @Override
    public String paymentInfoError(Integer id) {
        return "PaymentHystrixService fall back paymentInfoError";
    }
}
