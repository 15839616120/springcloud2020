package com.atguigu.cloudalibaba.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface PaymentDao {


    int cerate(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
