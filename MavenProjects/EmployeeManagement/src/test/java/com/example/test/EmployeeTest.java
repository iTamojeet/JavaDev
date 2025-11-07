package com.example.test;

import com.example.model.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testConstructorAndGetters() {
        Employee emp = new Employee(1, "John", 50000.0);
        assertEquals(1, emp.getId());
        assertEquals("John", emp.getName());
        assertEquals(50000.0, emp.getSalary());
    }

    @Test
    void testSetters() {
        Employee emp = new Employee();
        emp.setId(2);
        emp.setName("Alice");
        emp.setSalary(60000.0);

        assertEquals(2, emp.getId());
        assertEquals("Alice", emp.getName());
        assertEquals(60000.0, emp.getSalary());
    }

    @Test
    void testToString() {
        Employee emp = new Employee(3, "Bob", 70000.0);
        String expected = "Employee [id=3, name=Bob, salary=70000.0]";
        assertEquals(expected, emp.toString());
    }
}
