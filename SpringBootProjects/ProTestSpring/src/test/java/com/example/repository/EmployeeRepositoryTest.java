package com.example.repository;

import com.example.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    public void setup() {
        employee = Employee.builder()
        .name("Tamo")
        .email("t@gmail.com")
                .build();
    }

    @DisplayName("1st test")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

//        Employee employee = Employee.builder()
//                .name("Tamo")
//                .email("t@gmail.com")
//                .build();

        Employee savedEmployee=employeeRepository.save(employee);
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @DisplayName("2nd test")
    @Test
    public void givenEmployeeList_whenFindAll_thenEmplyeesList(){
        employeeRepository.save(employee);
        List<Employee> employees=employeeRepository.findAll();
        assertThat(employees).isNotNull();
        assertThat(employees.size()).isEqualTo(1);
    }

    @DisplayName("3rd test")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){
        employeeRepository.save(employee);
        Employee savedEmployee=employeeRepository.findById(employee.getId()).get();
        assertThat(savedEmployee).isNotNull();
    }
}
