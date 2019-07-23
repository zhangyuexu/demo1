package com.zyx.util.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor2 implements HandlerInterceptor {
    //进入controller方法之前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("LoginInterceptor---------->preHandle");
        String token = request.getParameter("access-token");
        //然后查下redis是否有这个token

        //如果有，就放行

        //如果没有，就response
        response.getWriter().print("token不正确");
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }
    //调用完controller之后，视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor---------->postHandle");
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);

    }
    //整个完成之后，用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor---------->afterCompletion");
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
}
