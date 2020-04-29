package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class AsynService {
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
