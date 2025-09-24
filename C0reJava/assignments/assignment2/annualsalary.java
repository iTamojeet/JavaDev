class Employee {

    private double basicSalary;

    // Getter and Setter methods for basic salary
    public double getBasicSalary() {
        return basicSalary;
    }

    
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    // Method to calculate the tax (10% of basic salary)
    private double calculateTax() {
        return 0.10 * basicSalary;
    }

    // Method to calculate the bonus (2% of basic salary)
    private double calculateBonus() {
        return 0.02 * basicSalary;
    }

    // Method to calculate the travelling allowance (1.5% of basic salary)
    private double calculateTravellingAllowance() {
        return 0.015 * basicSalary;
    }

    // Method to calculate the annual salary
    public double calculateAnnualSalary() {
        double monthlySalary = basicSalary + calculateBonus() + calculateTravellingAllowance();
        double annualSalary = (monthlySalary * 12) - calculateTax();
        return annualSalary;
    }

    // Method to display the basic salary and annual salary
    public void displaySalaryDetails() {
        System.out.println("Basic Salary: " + getBasicSalary());
        System.out.println("The annual salary of the employee is: " + calculateAnnualSalary());
    }

    public static void main(String[] args) {
        Employee emp = new Employee();  
        
        emp.setBasicSalary(70000);
        
        // Displays the salary details
        emp.displaySalaryDetails();
    }
}