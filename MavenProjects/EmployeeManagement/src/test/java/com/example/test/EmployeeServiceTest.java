package com.example.test;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private EmployeeService service;

    @BeforeEach
    void init() {
        service = new EmployeeService();
    }

    @ParameterizedTest
    @CsvSource({
            "1, John, 50000.0",
            "2, Alice, 60000.0",
            "3, Bob, 70000.0"
    })
    void testAddEmployeeParameterized(int id, String name, double salary) {
        service.addEmployee(new Employee(id, name, salary));
        assertEquals(name, service.getEmployeeById(id).getName());
    }

    @Test
    void testUpdateEmployee() {
        service.addEmployee(new Employee(1, "Sam", 40000));
        boolean updated = service.updateEmployee(1, "Samuel", 45000);
        assertTrue(updated);
        assertEquals("Samuel", service.getEmployeeById(1).getName());
    }

    @Test
    void testDeleteEmployee() {
        service.addEmployee(new Employee(1, "John", 50000));
        assertTrue(service.deleteEmployee(1));
        assertThrows(RuntimeException.class, () ->
                service.getEmployeeById(1));
    }

    @Test
    void testGetEmployeeByNonExistentId() {
        assertThrows(RuntimeException.class, () -> service.getEmployeeById(999));
    }

    @Test
    void testUpdateNonExistentEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> {
            service.updateEmployee(999, "NonExist", 10000);
        });
    }

    @Test
    void testDeleteNonExistentEmployee() {
        boolean deleted = service.deleteEmployee(999);
        assertFalse(deleted);
    }

    @ParameterizedTest
    @CsvSource({
            "4, , 45000",   // name empty
            "5, Dave, -100" // negative salary
    })
    void testAddEmployeeInvalidData(int id, String name, double salary) {
        assertThrows(IllegalArgumentException.class, () -> service.addEmployee(new Employee(id, name, salary)));
    }

}