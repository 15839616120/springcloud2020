package com.jiantou.cloud.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MyThirdMapper {
    @Select("select* from user where id  = 3")
    User select();

}
