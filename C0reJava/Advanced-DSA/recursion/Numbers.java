public class Numbers {
    public static void main(String[] args) {
        // Start printing from number 1
        print(1); 
    }

    static void print(int n) {
        // Base Condition: If n is 5, print it and stop.
        if (n == 5) {
            IO.println(5);
            return;
        }
        
        // Body: Print the current number
        IO.println(n);
        
        // Recursive Call: Call the function again with the next number
        print(n + 1);
    }
}