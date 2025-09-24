import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
class Employee {
    private String name;
    private double salary;

    public static void main(String[] args) {
        // Creating an array of employees
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Tamojeet", 5000.0);
        employees[1] = new Employee("Souparno", 6000.0);
        employees[2] = new Employee("Sayantani", 7000.0);

        // Find the employee with the highest salary using foreach loop
        Employee highestPaid = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > highestPaid.getSalary()) {
                highestPaid = employee;
            }
        }

        System.out.println("The highest-paid employee is: " + highestPaid.getName()+" and his/her salary is ₹"+highestPaid.getSalary());
    }
}
