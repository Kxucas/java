/*package com.example.demo.controller;

import com.example.demo.mapper.BooksMapper;
import com.example.demo.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class BooksController {
    @Autowired
    private BooksMapper booksMapper;

    @GetMapping("/emps")
    public String addUser(Model model){
        Collection<Books>booksMapper.queryBookList();
        model.addAttribute("emps",employees);
        return "list";
    }
    @GetMapping("/deleteUser")
    public String deleteUser(){
        booksMapper.deleteUser(121312);
        return "delete-ok";
    }
    @GetMapping("/queryBookList")
    public  List<Books> queryBookList(){
        return booksMapper.queryBookList();
    }
}
*/