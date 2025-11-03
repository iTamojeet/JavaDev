package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(int id) {
        return repository.findById(id);
    }

    public int add(Employee emp) {
        return repository.save(emp);
    }

    public int update(Employee emp) {
        return repository.update(emp);
    }

    public int delete(int id) {
        return repository.delete(id);
    }
}
