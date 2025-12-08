public class Fibonacci {
    public static void main(String[] args) {
        // Print the 4th Fibonacci number
        IO.println(fibo(4)); 
    }

    static int fibo(int n) {
        // Base Condition: fibo(0) is 0, fibo(1) is 1.
        if (n < 2) {
            return n;
        }
        
        // Recurrence Relation: Sum of the previous two numbers
        return fibo(n - 1) + fibo(n - 2);
    }
}