// Solution to question 10
class PrimeOdd {

    static void checkPrimeOdd(int i){
        // Check if the number is odd
        if (i % 2 != 0) {
            System.out.println(i + " is an odd number.");
            
            // Check if the number is prime
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(i + " is also a prime number.");
            } else {
                System.out.println(i + " is not a prime number.");
            }
        } else {
            System.out.println(i + " is not an odd number.");
        }
    }
    public static void main(String[] args) {
        checkPrimeOdd(7);
    }
}