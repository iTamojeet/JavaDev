// Solution to question 5
class SumOfEven{
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 20; i += 2) {
            sum += i;
            }
        System.out.println("Sum of even numbers from 1 to 20 is "+ sum);
    }
}