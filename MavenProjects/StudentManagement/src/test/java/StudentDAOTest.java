import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentDAOTest {
    private static StudentDAO dao;
    @BeforeAll
    static void init() { dao = new StudentDAOImpl(); }
    @Test
    @Order(1)
    void testAddStudent() {
        Student s = new Student(101, "Alice", 22, "Java");
        assertTrue(dao.addStudent(s));
    }
    @Test
    @Order(2)
    void testUpdateStudent() {
        Student s = new Student(101, "Alice Updated", 23, "Python");
        assertTrue(dao.updateStudent(s));
    }
    @Test
    @Order(3)
    void testGetStudentById() {
        assertNotNull(dao.getStudentById(101));
    }
    @Test
    @Order(4)
    void testGetAllStudents() {
        assertFalse(dao.getAllStudents().isEmpty());
    }
    @Test
    @Order(5)
    void testDeleteStudent() {
        assertTrue(dao.deleteStudent(101));
    }
}