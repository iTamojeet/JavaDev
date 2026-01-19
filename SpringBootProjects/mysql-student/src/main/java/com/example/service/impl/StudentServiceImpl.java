package com.example.service.impl;

import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection (BEST PRACTICE)
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

        @Override
        public Student addStudent(Student student) {
            return studentRepository.save(student);
        }

        @Override
        public List<Student> findAllStudents() {
            return studentRepository.findAll();
        }

        @Override
        public Student findStudentById(Long id) {
            return studentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Student with id "+id+" not found!!!"));
        }
    }