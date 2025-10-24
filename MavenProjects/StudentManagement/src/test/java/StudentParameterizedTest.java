import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentParameterizedTest {
    private final StudentDAO dao = new StudentDAOImpl();
    @ParameterizedTest
    @CsvSource({
            "201, John, 21, CSE",
            "202, Riya, 20, ECE",
            "203, Karan, 23, IT"
    })
    void testAddMultipleStudents(int id, String name, int age, String
            course) {
        assertTrue(dao.addStudent(new Student(id, name, age, course)));
    }
}