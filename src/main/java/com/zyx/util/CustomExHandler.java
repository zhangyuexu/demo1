package com.zyx.util;


import com.zyx.pojo.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExHandler.class);
    //捕获全局异常，处理所有不可知的异常
    @ExceptionHandler(value = Exception.class)//这个是按照Exception类定义的
    Object handleException(Exception e, HttpServletRequest request){//在这里传的是Exception类
        //也可以通过日志在后台把异常打出来
        LOG.error("url {},msg {}",request.getRequestURL(),e.getMessage());
        Map<String,Object> map = new HashMap<>();
        map.put("code",10000);
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURL());
        return map;
    }



    @ExceptionHandler(value = MyException.class)//这个是按照MyException自定义异常类定义的
    Object handleMyException(MyException e,HttpServletRequest request){//在这里传的是自定义异常类
        //也可以通过日志在后台把异常打出来
        LOG.error("code {},msg {}",e.getCode(),e.getMsg());
        Map<String,Object> map = new HashMap<>();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        map.put("url",request.getRequestURL());
        return map;
    }
}
