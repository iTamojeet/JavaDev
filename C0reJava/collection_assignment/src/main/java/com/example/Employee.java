package com.example;
/**
 * Author: iTamojeet
 * Date: 2024-03-05
 */
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int salary;             // Instance variables

    public Employee(String name, int salary) {
        this.name = name;                     // Constructor
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public static void printTotalSalary(List<Employee> employees) {  // Static method to calculate total salary
        int totalSalary = 0;
        for (Employee employee : employees) {               // Loop through the list of employees
            totalSalary += employee.getSalary();
        }
        System.out.println("Total Salary of all the employees is: " + totalSalary);
    }

    public static void main(String[] args) {  // Main method
        List<Employee> employees = new ArrayList<>();  // Creating a list of employees
        employees.add(new Employee("Souparno", 10000));
        employees.add(new Employee("Aditya", 11000));
        employees.add(new Employee("Annwesha", 12000));
        employees.add(new Employee("Sayantani", 13000));
        employees.add(new Employee("Tamojeet", 14000));

        printTotalSalary(employees);
    }
}