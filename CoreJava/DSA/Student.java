import java.util.*;

class Student{
    private int id;
    private String name;
    private String email;

    public Student(){}
    public Student(int id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return this.name;
    }
    public void setId(String name){
        this.name=name;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    @Override
    public String toString() {
        return "Student{id=" + this.id + ", name='" + this.name + "', email='" + this.email + "'}";
    }
}