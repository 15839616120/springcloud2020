package com.atguigu.springcloud.service;

        import org.springframework.stereotype.Service;

        import java.util.concurrent.TimeUnit;

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
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 模拟超时异常
     * @param id
     * @return
     */
    @Override
    public String paymentInfoError(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfoError,id: " + id + "\t" + "失败" + " 耗时3秒钟";
    }
}
