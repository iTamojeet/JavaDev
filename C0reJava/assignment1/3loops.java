// Solution to question 8
class Loops{

    // Method to print numbers from 1 to 10 using if loop
    static void printUsingIf() {
        int i = 1;
        if (i <= 10) {
            System.out.print(i + " ");
            printUsingIfHelper(i + 1);
        }
    }

    // Helper method for printUsingIf
    static void printUsingIfHelper(int i) {
        if (i <= 10) {
            System.out.print(i + " ");
            printUsingIfHelper(i + 1);
        }
    }

    // Method to print numbers from 1 to 10 using while loop
    static void printUsingWhile() {
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
    }

    // Method to print numbers from 1 to 10 using for loop
    static void printUsingFor() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Printing numbers from 1 to 10 using if loop:");
        printUsingIf();
        System.out.println("\n\nPrinting numbers from 1 to 10 using while loop:");
        printUsingWhile();
        System.out.println("\n\nPrinting numbers from 1 to 10 using for loop:");
        printUsingFor();
    }
}