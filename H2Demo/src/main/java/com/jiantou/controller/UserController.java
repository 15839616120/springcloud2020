package com.jiantou.controller;

import com.jiantou.dao.UserDao;
import com.jiantou.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping("findById")
    public User xfindById() {
        System.out.println(userDao.findById(1));
        User user = userDao.findById(1);
        return user;
    }
}
