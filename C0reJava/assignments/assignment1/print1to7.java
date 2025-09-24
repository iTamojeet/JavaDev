// Solution to question 1
class PrintNumbers {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            if (i == 3 || i == 5) {
                System.out.println("I am "+i);
            }
            else {
                System.out.println(i);
            }
        }
    }
}