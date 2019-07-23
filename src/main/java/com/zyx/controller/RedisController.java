package com.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v2/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;//同理jdbcTemplate

    /**
     * redisTemplate.opsForValue();//操作String
     * redisTemplate.opsForHash();//操作hash
     * redisTemplate.opsForList();//操作list
     * redisTemplate.opsForSet();//操作set
     * redisTemplate.opsForZSet();//操作有序set
     */
    @GetMapping(value = "add")
    public String add(){
        redisTemplate.opsForValue().set("name","ls");
        System.out.println("add");
        return "success";
    }

    @GetMapping(value = "get")
    public Map<String,String> get(){
        Map<String,String> map = new HashMap<>();
        String value = (String) redisTemplate.opsForValue().get("name");
        map.put("name",value);
        return map;
    }
}
