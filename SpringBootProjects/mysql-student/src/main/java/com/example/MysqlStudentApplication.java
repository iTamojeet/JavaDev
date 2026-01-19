package com.example;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MysqlStudentApplication implements Runnable{

    private final StudentRepository studentRepository;

    // Constructor Injection (MANDATORY)
    public MysqlStudentApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MysqlStudentApplication.class, args);
    }

    @Override
    @PostConstruct
    public void run() {

        // Prevent duplicate inserts on restart
        if (studentRepository.count() == 0) {

            studentRepository.saveAll(
                    List.of(
                            new Student("a", "a@gmail.com"),
                            new Student("b", "b@gmail.com"),
                            new Student("c", "c@gmail.com"),
                            new Student("d", "d@gmail.com"),
                            new Student("e", "e@gmail.com"),
                            new Student("f", "f@gmail.com")
                    )
            );

            System.out.println("-----------Initial students inserted----------");
        } else {
            System.out.println("!!!!!!!!!!Students already exist, skipping insert!!!!!!!!!!");
        }
    }
}
