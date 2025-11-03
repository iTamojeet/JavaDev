package com.example.repository;

import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee",
                new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM employee WHERE id=?",
                new BeanPropertyRowMapper<>(Employee.class),
                id);
    }

    public int save(Employee emp) {
        return jdbcTemplate.update(
                "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)",
                emp.getId(), emp.getName(), emp.getSalary());
    }

    public int update(Employee emp) {
        return jdbcTemplate.update(
                "UPDATE employee SET name=?, salary=? WHERE id=?",
                emp.getName(), emp.getSalary(), emp.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
    }
}
