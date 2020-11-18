package com.atguigu.cloudalibaba.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int cerate(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
