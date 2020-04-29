package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.mapper.BooksMapper;
import com.example.demo.pojo.Books;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class EmployeeController {
    //调用Service层
    @Autowired
    BooksMapper booksMapper;

    @RequestMapping("/emps")
    public String list(Model model){
        List<Books> books =booksMapper.queryBookList();
        model.addAttribute("emps",books);
        return "list";
    }
    //随便写的 json 前端是ajax 后端写的是json
    @ResponseBody
    @RequestMapping(value = "/json3")
    public String json3() throws JsonProcessingException {
        List<Books> list =new ArrayList<>();
        Books books1 =new Books(1,"e2",3,"ad");
        list.add(books1);
        return new ObjectMapper().writeValueAsString(list);
    }
    @PostMapping("/emp")
    public String addEmp(Books books){
        booksMapper.addUser(books);
        System.out.println(books);
        return "redirect:/emps";
    }
    @GetMapping("/add")
    public String toUpdateEmp(){
        //查出原来的数据
        //Books books =new Books(bookID,bookName,bookCounts,detail);
        //booksMapper.addUser(books);
        //model.addAttribute("emp",books);
        return "add";
    }
    @GetMapping("/delemp/{bookID}")
    public String delemp(@PathVariable("bookID")int bookID){
        booksMapper.deleteUser(bookID);
        return "redirect:/emps";
    }
    @GetMapping("/update/{bookID}")
    public String update(@PathVariable("bookID")int bookID,Model model){
        Books books =booksMapper.queryBookById(bookID);
        model.addAttribute("emp",books);
        return "update";
    }

    @PostMapping("updateEmp")
    public String updateEmp(Books books){
        booksMapper.updateBook(books);
        return "redirect:/emps";
    }

    @RequestMapping("/user/loginout")
    public String userlogout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
/*    @PostMapping("updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/delemp/{id}")
    public String delemp(@PathVariable("id")int id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
   */
}
