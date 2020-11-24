package com.jiantou.guifan.controller;


import com.jiantou.guifan.except.CheckException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StandardDemoController {

    @RequestMapping("/home")
    public String home1()  {

        throw new CheckException("101", "Sam 错误");

    }
}
