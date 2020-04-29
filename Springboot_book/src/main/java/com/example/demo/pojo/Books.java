package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Stack;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Books  {//序列化以后才能正常读取
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;


}
