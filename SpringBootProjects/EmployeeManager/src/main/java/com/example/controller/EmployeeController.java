package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public String add(@RequestBody Employee emp) {
        service.add(emp);
        return "Employee added successfully!";
    }

    @PutMapping
    public String update(@RequestBody Employee emp) {
        service.update(emp);
        return "Employee updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Employee deleted successfully!";
    }
}
