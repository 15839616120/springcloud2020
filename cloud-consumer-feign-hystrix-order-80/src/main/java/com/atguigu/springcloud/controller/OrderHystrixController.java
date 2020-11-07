package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentInfoErrorHandler",
                    commandProperties = {
                                          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
                                        })
    public String paymentInfoError(@PathVariable("id") Integer id){
        //系统错误异常
        //int a = 10/0;
        String result = paymentHystrixService.paymentInfoError(id);
        return result;
    };

    /**
     * 兜底方法【服务降级的方法】  超时或者系统异常都会走到这个兜底方法
     * @param id
     * @return
     */
    public String paymentInfoErrorHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfoErrorHandler,id: " + id +"我是消费者81,系统繁忙，请稍后重试";

    }
}
