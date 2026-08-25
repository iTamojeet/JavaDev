package com.example.dao.impl;

import com.example.config.Configuration;
import com.example.dao.DAO;
import com.example.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOImpl implements DAO {
    @Override
    public boolean addStudent(Student student) {
        try (Connection conn = new Configuration("mysql").getConn()) {
            PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?)");
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getAddress());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

//    @Override
//    public Student getStudent(int id) {
//        return null;
//    }
//
//    @Override
//    public List<Student> getAllStudents() {
//        return List.of();
//    }
//
//    @Override
//    public boolean updateStudent(int id, Student student) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteStudent(int id) {
//        return false;
//    }
}
