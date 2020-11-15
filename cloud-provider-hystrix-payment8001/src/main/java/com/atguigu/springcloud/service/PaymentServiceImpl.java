package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wuyz1
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问ok的方法
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfoOk,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    //======服务降级
    /**
     * 模拟超时异常
     * fallbackMethod 服务降级执行的方法
     * timeoutInMilliseconds:降级处理超时时间设置
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoErrorHandler",
                    commandProperties = {
                           @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfoError(Integer id) {
        //异常1
        //int s = 10/0;
        try {
            //异常2
            TimeUnit.SECONDS.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfoError,id: " + id + "\t"  + " 8001成功啦";
    }

    /**
     * 兜底方法【服务降级的方法】  超时或者系统异常都会走到这个兜底方法
     * @param id
     * @return
     */
    public String paymentInfoErrorHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfoErrorHandler,id: " + id +"8001系统繁忙，请稍后重试";

    }
    //======服务熔断
    @Override
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
            }
    )
    public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("*******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号： "+serialNumber;
    }

    /**
     * 截至到第59个视频，回头接着59继续整合
     * @param id
     * @return
     */
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请稍后再试  id: "+id;
    }
}
