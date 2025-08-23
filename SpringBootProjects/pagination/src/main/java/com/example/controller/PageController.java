package com.example.controller;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class PageController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("page/{pageno}/{pagesize}")
    public List<Employee> getEmployees(@PathVariable Integer pageno, @PathVariable Integer pagesize){
        Pageable pageable = PageRequest.of(pageno,pagesize);
        Page<Employee> page = employeeRepository.findAll(pageable);
        List<Employee> employees = page.getContent();
        return employees;
    }
}
