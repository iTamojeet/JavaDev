package com.example.service;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Flux<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Mono<Employee> getEmployeeById(Integer id) {
        return repository.findById(id);
    }

    public Mono<Employee> createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Mono<Void> deleteEmployee(Integer id) {
        return repository.deleteById(id);
    }
}
