package com.example.service;

import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);
    public List<Student> findAllStudents();
    public Student findStudentById(Long id);
}
