package com.zyx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource({"classpath:myapplication.yaml"})
public class MiyaController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

        @GetMapping("/miya")
    public String miya(){

        return name+" : "+age;
    }
}
