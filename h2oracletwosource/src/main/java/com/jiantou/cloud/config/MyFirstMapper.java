package com.jiantou.cloud.config;


import com.github.xuyuansheng.xbdynamicdatasource.dynamic.annotation.DynamicDS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
@DynamicDS("master")
public interface MyFirstMapper {
    @Select("select* from user where id  = 1")
    User select();
}
