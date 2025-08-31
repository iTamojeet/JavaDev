// Solution to question 9
class Factorial{

    // Static method to calculate factorial
    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Main method to call the factorial method
    public static void main(String[] args) {
        int number = 5; // Example number to find factorial
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}