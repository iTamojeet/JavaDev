package com.example.controller;

import com.example.entity.Emp;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("page")
    public ResponseEntity<List<Emp>> getEveryEmployee(){
        return ResponseEntity.ok(empService.getAllByPage());
    }

    @GetMapping("all")
    public ResponseEntity<List<Emp>> getAllEmployee(){
        return ResponseEntity.ok(empService.getAll());
    }
}
