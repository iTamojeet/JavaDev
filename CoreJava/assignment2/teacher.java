class Teacher {
    private String tname; // instance variable
    private String subject; // instance variable
    private int yearsOfExperience; // instance variable

    // Getter and Setter methods
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getYrsOfExp() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}

class Student {
    private String sname; // instance variable
    private String degree; // instance variable
    private String college; // instance variable

    // Getter and Setter methods
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}

class Relationship {

    // Method to set details for Teacher
    public static void setTeacherDetails(Teacher teacher, String tname, String subject, int yearsOfExperience) {
        teacher.setTname(tname);
        teacher.setSubject(subject);
        teacher.setYearsOfExperience(yearsOfExperience);
    }

    // Method to set details for Student
    public static void setStudentDetails(Student student, String sname, String degree, String college) {
        student.setSname(sname);
        student.setDegree(degree);
        student.setCollege(college);
    }

    public static void TeacherStudent(Teacher teacher, Student student) {
        System.out.println(student.getSname() + " takes " + student.getDegree() + " class under " + teacher.getTname() + " Sir");
    }

    public static void TeacherStudentDetails(Teacher teacher, Student student) {
        System.out.println(teacher.getTname() + " Sir teaches " + teacher.getSubject() + " to " + student.getSname() +
            " reading as " + student.getDegree() + " in " + student.getCollege() + " college");
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        setTeacherDetails(teacher, "Amitava", "OOPS DESIGN", 10);  

        Student ankan = new Student();
        setStudentDetails(ankan, "Ankan", "Java", "UEM");  

        Student madhu = new Student();
        setStudentDetails(madhu, "Madhu", "Btech", "UEM");  

        // Using static methods to establish teacher-student relationship
        TeacherStudent(teacher, ankan);
        TeacherStudentDetails(teacher, madhu);
    }
}