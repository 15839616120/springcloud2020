package com.jiantou.dao;

import com.jiantou.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    @Select("select * from user where id= #{id}")
    User findById(Integer id);
}
