package com.example.repository;

import com.example.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRespositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    public void setup() {
        employee = Employee.builder()
        .id(1)
        .name("Tamo")
        .email("t@gmail.com").build();
    }

    @DisplayName("1st testing")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

        Employee savedEmployee=employeeRepository.save(employee);
        assertThat(savedEmployee).isNotNull();
    }
}
