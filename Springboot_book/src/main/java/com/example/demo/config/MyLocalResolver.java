package com.example.demo.config;

import com.sun.corba.se.spi.orbutil.closure.Closure;
import com.sun.corba.se.spi.resolver.LocalResolver;
import org.omg.CORBA.Object;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;
//国际化类
public class MyLocalResolver implements LocaleResolver {
//解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language =request.getParameter("l");

        Locale locale =Locale.getDefault(); //如果没有使用默认的
        if(!StringUtils.isEmpty(language)){
            String[] split =language.split("_");
          locale =new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
