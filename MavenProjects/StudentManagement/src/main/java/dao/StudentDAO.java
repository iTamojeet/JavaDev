package dao;

import model.Student;

import java.util.*;

public interface StudentDAO {
    boolean addStudent(Student s);
    boolean updateStudent(Student s);
    boolean deleteStudent(int id);
    Student getStudentById(int id);
    List<Student> getAllStudents();
}