package com.atguigu.springclud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springclud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    };

    /**
     * 测试openfeign超时控制
     * @return
     */
    @GetMapping("/consumer/payment/paymentFeignTimeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon,客户端一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
