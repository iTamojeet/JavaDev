package com.example.service;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    // CREATE
    public void addEmployee(Employee emp) {
        if (emp.getName() == null || emp.getName().isEmpty() || emp.getSalary() < 0) {
            throw new IllegalArgumentException("Invalid employee data");
        }
        employeeList.add(emp);
    }

    // READ
    public Employee getEmployeeById(int id) {
        return employeeList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    // UPDATE
    public boolean updateEmployee(int id, String newName, double
            newSalary) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                emp.setName(newName);
                emp.setSalary(newSalary);
                return true;
            }
        }
        throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }

    // DELETE
    public boolean deleteEmployee(int id) {
        return employeeList.removeIf(e -> e.getId() == id);
    }

    // LIST ALL
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeList);
    }
}