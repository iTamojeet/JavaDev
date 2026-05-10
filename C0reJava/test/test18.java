import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    public int getMarks() {
        return this.marks;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }

    @Override
    public String toString() {
        return "Name " + this.name + " marks " + this.marks + " Name " + other.name + " marks " + other.marks;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getName().comapreTo(s2.getName());
    }
}