package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class IndexController {
    @RequestMapping("/Test")
    public String Test(Model model){
        model.addAttribute("msg","<h1>hellospringboot</h1>");

        model.addAttribute("users", Arrays.asList("123","456"));
        return "Test";
    }
    @RequestMapping("/test1")
    public String test(Model model){
        model.addAttribute("msg","<h1>hellospringboot</h1>");

        model.addAttribute("users", Arrays.asList("123","456"));
        return "test1";
    }

    @RequestMapping({"/","index.html"})
    public String page(){
        //具体的业务
        return "index";
    }
    @RequestMapping({"list.html"})
    public String page1(){
        //具体的业务
        return "list";
    }
    @RequestMapping({"/user/login"})
    public String page2(@RequestParam("username")String username, @RequestParam("password")String password, Model model, HttpSession session){
        //具体的业务
        if("root".equals(username) &&"123456".equals(password) ){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }

        else{
           model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }

    }
}
