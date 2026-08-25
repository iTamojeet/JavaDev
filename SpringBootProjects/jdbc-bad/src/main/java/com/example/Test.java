package com.example;

import com.example.config.Configuration;
import com.example.dao.DAO;
import com.example.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    static void main() throws SQLException {

        Connection conn_mysql = new Configuration("MySQL").getConn();
        IO.println(conn_mysql);

        Connection conn_oracle = new Configuration("Oracle").getConn();
        IO.println(conn_oracle);

        DAO dd = (student) -> {
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
        };

        IO.println(dd.addStudent(new Student(3, "Tamo", "Dubai")) ? "Done" : "Not done!");


//        DAO d = new DAOImpl();
//        IO.println(d.addStudent(new Student(1, "Tamo", "Dubai")) ? "Done" : "Not done!");

//        IO.println(System.getProperty("java.version"));
//        IO.println("Jali connection established: " + Configuration.makeCon_mysql());
    }
}
