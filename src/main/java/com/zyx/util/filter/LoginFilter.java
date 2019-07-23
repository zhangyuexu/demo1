package com.zyx.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/v1/*",filterName = "loginFilter")
public class LoginFilter implements Filter {

    //容器加载时就调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginfilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter loginfilter");
        HttpServletRequest res = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String username = res.getParameter("username");
        if("zyx".equals(username)){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            resp.sendRedirect("/login.html");
            return;
        }
    }

    @Override
    public void destroy() {

        System.out.println("destroy loginfilter");

    }
}
