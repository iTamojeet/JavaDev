class Employee {
    private String ename; // instance variable
    private String designation; // instance variable
    private String email; // instance variable
    private double salary; // instance variable

    // Getter and Setter methods for employee details
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void EmployeeDetails() {
        System.out.println(ename + " is a " + designation + ". He/She has email id " + email + " and their salary is " + salary);
    }

    // method for setting employee details
    public void setEmployeeDetails(String ename, String designation, String email, double salary) {
        setEname(ename);
        setDesignation(designation);
        setEmail(email);
        setSalary(salary);
    }

    public static void main(String[] args) {
        Employee ankan = new Employee();
        ankan.setEmployeeDetails("Ankan", "Developer", "ank@ibm.com", 5000);
        
        // Display employee details
        ankan.EmployeeDetails();
    }
}