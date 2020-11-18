package com.atguigu.cloudalibaba.service;

import com.atguigu.cloudalibaba.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    /**
     *  @Resource  java自带的
      */

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int cerate(Payment payment) {
        return paymentDao.cerate(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
