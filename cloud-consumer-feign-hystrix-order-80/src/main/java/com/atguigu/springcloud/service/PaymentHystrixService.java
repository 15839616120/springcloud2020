package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuyz1
 * fallback = PaymentFallbackService.class 是自定义的服务降级统一处理类
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment" ,fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {


    /**
     * 正常访问ok的方法
     * @param id
     * @return
     * @PathVariable 这个注解刚开始忘记加了，报了404错误
     */
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo(@PathVariable("id") Integer id);


    /**
     * 模拟超时异常
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/error/{id}")
    String paymentInfoError(@PathVariable("id") Integer id);
}
