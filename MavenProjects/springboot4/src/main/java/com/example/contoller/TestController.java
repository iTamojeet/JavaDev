package com.example.contoller;

import com.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@AllArgsConstructor
public class TestController {

    private UserService userService;

    // http://localhost:8080/api/v1/hello
    @GetMapping(version = "1")
    public String test1(){
        return "<h1>Spring Boot version 1!!!!</h1>";
    }

    // http://localhost:8080/api/v2/hello
    @GetMapping(version = "2")
    public String test2(){
        return "<h1>Spring Boot version 2!!!!</h1>";
    }

    // http://localhost:8080/api/v3/hello
    @GetMapping(version = "3")
    public String test3(){
        return "<h1>Spring Boot version 3!!!!</h1>";
    }

    // http://localhost:8080/api/v4/hello
    @GetMapping(version = "4")
    public String test4(){
        return "<h1>Spring Boot version 4!!!!</h1>";
    }


    // http://localhost:8080/api/v5/hello
    @GetMapping(version = "5")
    public String test5(){
        return userService.takeName("Tamojeet");
    }
}
