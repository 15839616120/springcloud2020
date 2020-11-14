package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTestDao {

    User findById(Integer id);
}
