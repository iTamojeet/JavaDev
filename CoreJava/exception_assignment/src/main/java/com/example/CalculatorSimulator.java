package com.example;

public class CalculatorSimulator {
    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();

        String empName = "";
        boolean isIndian = true;
        double empSal = 155000;

        try {
            double tax = calculator.calculateTax(empName, isIndian, empSal);
            printTaxAmount(tax);
        } catch (CountryNotValidException e) {

            System.out.println("The employee should be an Indian citizen for calculating tax");
        } catch (EmployeeNameInvalidException e) {

            System.out.println("The employee name cannot be empty");
        } catch (TaxNotEligibleException e) {

            System.out.println("The employee does not need to pay tax");
        }
    }

    private static void printTaxAmount(double tax) {
        if (tax == (int) tax) {
            System.out.println("Tax amount is " + (int) tax);
        } else {
            System.out.println("Tax amount is " + tax);
        }
    }
}