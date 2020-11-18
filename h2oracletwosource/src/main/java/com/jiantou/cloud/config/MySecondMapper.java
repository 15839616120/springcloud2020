package com.jiantou.cloud.config;

import com.github.xuyuansheng.xbdynamicdatasource.dynamic.annotation.DynamicDS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
@DynamicDS("slave")
public interface MySecondMapper {
    @Select("select* from user where id  = 2")
    User select();

}
