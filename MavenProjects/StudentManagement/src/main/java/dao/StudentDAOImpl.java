package dao;

import model.Student;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getCourse());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            IO.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean updateStudent(Student s) {
        String sql = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            IO.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            IO.println(e.getMessage());
        }
        return false;
    }
    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("course"));
            }
        } catch (SQLException e) {
            IO.println(e.getMessage());
        }
        return null;
    }
    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("course")));
            }
        } catch (SQLException e) {
            IO.println(e.getMessage());
        }
        return list;
    }
}