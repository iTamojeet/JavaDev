package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
//@RequestMapping("api")
@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ModelAndView getAllStudents(){
        ModelAndView mav = new ModelAndView("mango");
        mav.addObject("mystudents", studentService.findAllStudents());
        return mav;
    }

//    @PostMapping
//    public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
//        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Student>> findEveryStudent(){
//        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
//    }
//
//    @GetMapping("id/{id}")
//    public ResponseEntity<Student> findStudentByID(@PathVariable Long id){
//        return ResponseEntity.ok(studentService.findStudentById(id));
//    }
}
