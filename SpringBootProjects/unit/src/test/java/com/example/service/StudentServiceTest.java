package com.example.service;

import com.example.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void getStudents() {
        StudentService studentService = new StudentService();
        List<Student> students = studentService.getStudents();
        //boolean b = students.isEmpty();
        //assertTrue(b);
        //assertFalse(() -> students.isEmpty(), "students is empty");
        assertTrue(() -> students.isEmpty());
    }

    @Test
    void getStudentById() {
        StudentService studentService = new StudentService();
        Student student = new Student(1,"Tamo","Science");
        studentService.setStudents(student);
        Student stu = studentService.getStudentById(1);
        assertNull(stu);
    }

    @Test
    void getStudentNamesByDept(){
        StudentService studentService = new StudentService();

        Student s1 = new Student(1,"Tamo","Science");
        Student s2 = new Student(2,"Tamojeet","Computer Science");
        Student s3 = new Student(3,"Didi","TMC");

        studentService.setStudents(s1);
        studentService.setStudents(s2);
        studentService.setStudents(s3);

        String[] actualArray = studentService.getStudentNamesByDepartment("TMC");
        String[] expectedArray = {"Didi"};
        assertArrayEquals(expectedArray,actualArray);
    }

    @Test
    void getStudentByName(){
        StudentService studentService = new StudentService();

        Student s1 = new Student(1,"Tamo","Science");
        Student s2 = new Student(2,"Tamojeet","Computer Science");
        Student s3 = new Student(3,"Didi","TMC");

        studentService.setStudents(s1);
        studentService.setStudents(s2);
        studentService.setStudents(s3);

        assertEquals("Tamojeet",studentService.getStudentByName("Tamojeet").getName());
    }
}