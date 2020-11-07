package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuyz1
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * 正常访问ok的方法
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo(id);
        return result;
    };



    /**
     * 模拟超时异常
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/hystrix/error/{id}")
    public String paymentInfoError(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoError(id);
        return result;
    };
}
