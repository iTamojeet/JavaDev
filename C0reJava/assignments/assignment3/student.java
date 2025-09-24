
class Student {
    private int roll;
    private String name;
    private double marks;

    Student(int roll, String name, double marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    // Method to update marks based on certification
    public void updateMarks(String certification) {
        switch (certification) {
            case "OCJP":
                this.marks += 90;
                break;
            case "OCA":
                this.marks += 80;
                break;
            case "MCSA":
                this.marks += 77;
                break;
            case "GCP":
                this.marks += 92;
                break;
            default:
                System.out.println("Invalid certification: " + certification);
        }
    }

    @Override
    public String toString() {
        return "Roll: " + roll + ", Name: " + name + ", Marks: " + marks;
    }

    public static void main(String[] args) {
        // Create an array of 3 students
        Student[] students = new Student[3];
        students[0] = new Student(101, "Tamojeet", 400);
        students[1] = new Student(102, "Souparno", 450);
        students[2] = new Student(103, "Sayantani", 480);

        // Print actual student details
        System.out.println("Updated Student Details:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("-------------------------------------");

        // Update marks based on certifications
        students[0].updateMarks("OCJP");
        students[1].updateMarks("GCP");
        students[2].updateMarks("MCSA");

        // Print updated student details
        System.out.println("Updated Student Details:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
