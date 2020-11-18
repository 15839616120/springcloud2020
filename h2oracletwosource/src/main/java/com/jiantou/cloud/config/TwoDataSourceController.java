package com.jiantou.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoDataSourceController {

    @Autowired
    private MyFirstMapper myFirstMapper;
    @Autowired
    private MySecondMapper mySecondMapper;
    @Autowired
    private MyThirdMapper myThirdMapper;

    @RequestMapping("getMaster")
    public Object getMaster(){
        User select = myFirstMapper.select();
        return select;
    }
    @RequestMapping("getSecond")
    public Object getSecond(){
        User select = mySecondMapper.select();
        return select;
    }
    @RequestMapping("getThird")
    public Object getThird(){
        User select = myThirdMapper.select();
        return select;
    }
}
