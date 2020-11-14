package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.dao.User;
import com.atguigu.springcloud.dao.UserTestDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserTestDao userTestDao;

    @RequestMapping("findById")
    public User findById() {
        System.out.println(userTestDao.findById(1));
        User user = userTestDao.findById(1);
        return user;
    }
}
