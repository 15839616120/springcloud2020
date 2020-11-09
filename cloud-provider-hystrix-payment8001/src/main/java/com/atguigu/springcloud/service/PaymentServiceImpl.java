package com.atguigu.springcloud.service;

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
}
