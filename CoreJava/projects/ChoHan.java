import java.util.*;

/*
Cho-han(“even-odd”) is a traditional Japanese dice game with simple rules:
• The player bets if the sum of two six-sided dice will be odd or even.
• If the player’s guess is correct, he wins. If not, he loses.
Let’s write a program for cho-han.
*/

class ChoHan{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Cho-Han.");
        System.out.println("1. Even");
        System.out.println("2. Odd");
        System.out.println("Select a bet.");

        int bet = sc.nextInt();

        // Roll the two dice
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int sum = die1 + die2;

        System.out.printf("The dice are %d and %d.\n", die1, die2);
        System.out.printf("The sum is %d.\n", sum);

        if (bet == 1 && sum % 2 == 0) { // Winning even bet
            System.out.println("You win.");
        } else if (bet == 2 && sum % 2 == 1) { // Winning odd bet
            System.out.println("You win.");
        } else { // Every other combination loses
            System.out.println("You lose.");
        }
    }
}