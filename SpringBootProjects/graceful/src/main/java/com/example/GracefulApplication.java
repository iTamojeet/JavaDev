package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GracefulApplication {

    @GetMapping
    public String index() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(GracefulApplication.class, args);
    }

}
