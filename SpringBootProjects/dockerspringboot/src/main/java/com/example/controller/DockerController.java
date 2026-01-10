package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DockerController {

    @GetMapping
    public String hello(){
        return "<center><h1>Java version: "+System.getProperty("java.version")+"</h1></center>";
    }
}
