package com.zyx.controller;

import com.zyx.pojo.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/v1/sayhello")
    public String sayHello(String name){
        System.out.println("spring-boot版本必须是2.1.1才能热部署");
        System.out.println(1/0);
        return "Hello " + name;
    }

    @GetMapping("/v1/hh")
    public String hh(){

        throw new MyException(404,"自定义异常");//controller调用其构造方法
    }


}
