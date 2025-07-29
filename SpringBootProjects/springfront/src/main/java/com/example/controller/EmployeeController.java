package com.example.controller;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView("list-employees");
        modelAndView.addObject("employees", employeeRepository.findAll());
        return modelAndView;
    }
    @GetMapping("/emp")
    @ResponseBody
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
