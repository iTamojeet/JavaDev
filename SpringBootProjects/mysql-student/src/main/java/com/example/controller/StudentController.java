package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findEveryStudent(){
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Student> findStudentByID(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findStudentById(id));
    }
}
