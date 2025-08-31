package com.example;
/**
 * Author: iTamojeet
 * Date: 2024-03-05
 */

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    String degree;                                     // Instance variables

    public Student(String name, String degree) {
        this.name = name;
        this.degree = degree;           // Constructor
    }

    public String getName() {
        return name;
    }

    public String getDegree() {
        return degree;
    }

    public static void PrintOnlyBtech(List<Student> students) {
        List<String> btechStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getDegree().equals("Btech")) {
                btechStudents.add(student.getName());            // Adding only Btech students to the list
            }
        }
        for (String name : btechStudents) {
            System.out.println(name);     // Print the names of Btech students
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();   // Creating a list of students
        students.add(new Student("Tamojeet", "Btech"));
        students.add(new Student("Souparno", "BCA"));
        students.add(new Student("Sayantani", "Btech"));
        students.add(new Student("Aditya", "BCA"));
        students.add(new Student("Annwesha", "BCA"));

        PrintOnlyBtech(students);
    }
}