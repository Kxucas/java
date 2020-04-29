package com.example.demo;

import com.example.demo.pojo.Books;
import com.example.demo.pojo.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    @Qualifier(value = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private Person person;
    @Test
    void contextLoads(){
        System.out.println(dataSource.getClass());
        System.out.println(person.getAge());
        //操做字符串 操做不同的数据类型
        redisTemplate.opsForSet();
        redisTemplate.opsForHash();
        redisTemplate.opsForValue();//操作字符串 类似string
        redisTemplate.opsForList();//操做List
        RedisConnection connection =redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        connection.flushAll();

        redisTemplate.opsForValue().set("mykey","kaixuan");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }
    @Test
    public void test() throws JsonProcessingException {
        Books book =new Books(3123,"dada",213123,"adqeq2eqa");
        String jsonBook =new ObjectMapper().writeValueAsString(book);
        redisTemplate.opsForValue().set("book",book);
        System.out.println(redisTemplate.opsForValue().get("book"));


    }


}
