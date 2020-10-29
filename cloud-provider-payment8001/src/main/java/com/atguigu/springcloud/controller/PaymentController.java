package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wuyz1
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value ="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.cerate(payment);
        log.info("插入结果"+result);
        if (result>0){
            return new CommonResult(200,"插入成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(500,"插入失败,serverPort:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果"+payment);
        if (payment == null){
            return new CommonResult(500,"没有对应的记录，查询失败,serverPort:"+serverPort,null);
        }else {
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取所有微服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }
        //获取指定微服务的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance:"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 测试openfeign超时控制
     * @return
     */
    @GetMapping("/payment/paymentFeignTimeout")
    public String paymentFeignTimeout(){

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
