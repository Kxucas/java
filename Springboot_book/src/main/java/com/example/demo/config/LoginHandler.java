package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandler implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功后 有用户的seesion
        Object loginUser =request.getSession().getAttribute("loginUser");
        if(loginUser ==null){
            request.setAttribute("msg","没有权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else
            return true;
    }
}
