package com.example.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    //@Async
    @GetMapping("/output")
    public void callMe(){
        System.out.println(Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName());
    }
}
