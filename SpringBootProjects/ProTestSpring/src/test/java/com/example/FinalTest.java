package com.example;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
public class FinalTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @DisplayName("JUnit test for get employee by id")
    @Test
    @Order(2)
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){

        Employee savedEmployee=employeeRepository.findById(1).get();
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
        assertThat(savedEmployee.getName()).isEqualTo("Tamo");
    }

    @DisplayName("JUnit test to save employee")
    @Test
    @Order(1)
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

        Employee employee = Employee.builder()
                .name("Tamo")
                .email("t@gmail.com")
                .build();

        Employee savedEmployee=employeeRepository.save(employee);
        assertThat(savedEmployee).isNotNull();
    }
}
