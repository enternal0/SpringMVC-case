package com.dan.javaweb.springmvc.filter;

import com.dan.javaweb.springmvc.control.HelloWorldControler;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Object user=session.getAttribute("username");
        System.out.println("已拦截");
        return user!=null;
    }
}
