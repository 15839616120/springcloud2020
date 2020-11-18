package com.atguigu.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    //配置feign的日志级别
    @Bean
    Logger.Level feignLogerLevel(){
        return Logger.Level.BASIC;
    }
}
