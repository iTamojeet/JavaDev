package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class Controller {
    @GetMapping("/sum/{a}/{b}")
    public ResponseEntity<Integer> sumOf(@PathVariable int a, @PathVariable int b){
        return ResponseEntity.ok(a+b);
    }
    @GetMapping("/strlist/{name1}/{name2}")
    public ResponseEntity<List<String>> getNames(@PathVariable String name1, @PathVariable String name2){
        return ResponseEntity.ok(List.of(name1, name2));
    }
}
