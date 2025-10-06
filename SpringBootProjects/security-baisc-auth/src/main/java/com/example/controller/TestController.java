package com.example.controller;

import com.example.entity.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping
    public String testing(){
        return "<h1>Spring Boot Security Testing</h1>";
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Student createStudent(@RequestBody Student student){
        return new Student(student.getName(), student.getClg());
    }
}
