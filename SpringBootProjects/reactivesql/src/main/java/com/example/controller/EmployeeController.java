package com.example.controller;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public Flux<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getEmployee(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEmployee(@PathVariable Integer id) {
        return service.deleteEmployee(id);
    }
}

