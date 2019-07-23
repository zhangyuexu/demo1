package com.zyx.util.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/v1/*/**");
//        registry.addInterceptor(new LoginInterceptor2()).addPathPatterns("/v2/*/**");//当多个拦截器就注册多个
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
