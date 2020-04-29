package com.example.demo.controller;

import com.example.demo.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {

    @Autowired
    AsynService asynService;
    @RequestMapping("/hello")
    public String hello(){
        asynService.hello();
        System.out.println("数据正在处理");
        return "OK";
    }
}
