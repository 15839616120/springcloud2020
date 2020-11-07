package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuyz1
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port} ")
    private String serverPort;

    /**
     * http://localhost:8001/payment/hystrix/ok/1
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo(id);
        log.info("*****result: "+result);
        return result;
    }

    /**
     * http://localhost:8001/payment/hystrix/error/1
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/error/{id}")
    public String paymentInfoError(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoError(id);
        log.info("*****result: "+result);
        return result;
    }
}
