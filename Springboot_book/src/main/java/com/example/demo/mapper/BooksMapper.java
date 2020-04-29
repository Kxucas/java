package com.example.demo.mapper;

import com.example.demo.pojo.Books;
import  org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BooksMapper {
    public static int age =18;
    List<Books> queryBookList();
    Books queryBookById(int bookID);
    String addUser(Books books);
    void updateBook(Books books);
    String deleteUser(int bookID);
}
