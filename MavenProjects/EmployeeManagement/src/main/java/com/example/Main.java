package com.example;

import java.util.*;
import com.example.model.Employee;
import com.example.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);
        int id;
        String name;
        double salary;
        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();
                        System.out.print("Enter Name: ");
                        name = sc.next();
                        System.out.print("Enter Salary: ");
                        salary = sc.nextDouble();
                        service.addEmployee(new Employee(id, name, salary));
                        System.out.println("Employee added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter ID: ");
                        id = sc.nextInt();
                        System.out.println(service.getEmployeeById(id));
                        break;
                    case 3:
                        System.out.print("Enter ID to update: ");
                        id = sc.nextInt();
                        System.out.print("Enter new Name: ");
                        name = sc.next();
                        System.out.print("Enter new Salary: ");
                        salary = sc.nextDouble();
                        service.updateEmployee(id, name, salary);
                        System.out.println("Employee updated successfully!");
                        break;
                    case 4:
                        System.out.print("Enter ID to delete: ");
                        id = sc.nextInt();
                        if (service.deleteEmployee(id))
                            System.out.println("Employee deleted successfully!");
                        else
                            System.out.println("Employee not found!");
                        break;
                    case 5:
                        System.out.println("All Employees:");
                        service.getAllEmployees().forEach(System.out::println);
                        break;
                    case 6:
                        System.out.println("Exiting... Goodbye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}