import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

void main() {
        StudentDAO dao = new StudentDAOImpl();
        while (true) {
            IO.println("\n=== Student Management System ===");
            IO.println("1. Add Student");
            IO.println("2. Update Student");
            IO.println("3. Delete Student");
            IO.println("4. View Student by ID");
            IO.println("5. View All Students");
            IO.println("6. Exit");
            IO.print("Enter your choice: ");
            int ch = Integer.parseInt(IO.readln());
            switch (ch) {
                case 1 -> {
                    IO.print("Enter ID: "); int id = Integer.parseInt(IO.readln());
                    IO.print("Enter Name: "); String name = IO.readln();
                    IO.print("Enter Age: "); int age = Integer.parseInt(IO.readln());
                    IO.print("Enter Course: "); String course = IO.readln();
                    boolean added = dao.addStudent(new Student(id, name, age, course));
                    IO.println(added ? "Student Added!" : "Failed to add.");
                }
                case 2 -> {
                    IO.print("Enter ID: "); int id = Integer.parseInt(IO.readln());
                    IO.print("Enter New Name: "); String name = IO.readln();
                    IO.print("Enter New Age: "); int age = Integer.parseInt(IO.readln());
                    IO.print("Enter New Course: "); String course = IO.readln();
                    boolean updated = dao.updateStudent(new Student(id, name, age, course));
                    IO.println(updated ? "Updated!" : "Update Failed!");
                }
                case 3 -> {
                    IO.print("Enter ID: "); int id = Integer.parseInt(IO.readln());
                    IO.println(dao.deleteStudent(id) ? "Deleted!" : "Not Found!");
                }
                case 4 -> {
                    IO.print("Enter ID: "); int id = Integer.parseInt(IO.readln());
                    IO.println(dao.getStudentById(id));
                }
                case 5 -> dao.getAllStudents().forEach(IO::println);
                case 6 -> { IO.println("Exiting..."); return; }
                default -> IO.println("Invalid Choice!");
            }
        }
}