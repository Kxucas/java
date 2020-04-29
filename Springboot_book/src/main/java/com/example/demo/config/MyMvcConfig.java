package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;
//如果我们扩展springmvc  官方建议我们这么做
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //实现了视图解析器的类 就当作是视图解析器
    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {


            registry.addViewController("/kuang").setViewName("index"); //用kuang跳转到Test页面
            registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public ViewResolver myViewResolver(){
        return new MyVireResolver();
    }

    //定义自己的视图解析器
    public static class MyVireResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }


    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {//配置拦截器
        registry.addInterceptor(new LoginHandler()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/css/*","/js/**","/img/**");
    }
}
