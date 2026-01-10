package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "emp1")
public class Emp {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String fname;
    @Column(name = "LAST_NAME")
    private String lname;
    @Column(name = "SALARY")
    private Integer sal;
}
