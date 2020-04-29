package com.example.demo.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//自定义注解
@Retention(RetentionPolicy.RUNTIME)//运行时
@Target(ElementType.METHOD)//方法
public @interface adminOnly {

}
