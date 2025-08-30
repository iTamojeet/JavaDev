package com.example.service;

import com.example.Student;
import com.example.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> students = new ArrayList<>();
    public List<Student> getStudents() {
        return this.students;
    }
    public void setStudents(Student student) {
        students.add(student);
    }
    public Student getStudentById(int id) {
        return students.stream()
                .filter((student) -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public String[] getStudentNamesByDepartment(String department) {
        return students.stream()
                .filter((student -> student.getDepartment().equals(department)))
                .map(Student::getName)
                .toArray(String[]::new);
    }
    public Integer[] getStudentIdsByDepartment(String department) {
        return students.stream()
                .filter((student -> student.getDepartment().equals(department)))
                .map(Student::getId)
                .toArray(Integer[]::new);
    }
    public Student getStudentByName(String name){
        return students.stream()
                .filter((student) -> student.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student not found with name "+name));
    }
}
