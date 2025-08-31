// Solution to question 3
class CompareNumbers {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide exactly three numbers as command-line arguments.");
            return;
        }

        // Parse command-line arguments
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        // Find the largest of the first two numbers
        int largest = 0;
        if(num1>num2){
            largest=num1;
        }else{
            largest=num2;
        }

        // Calculate the sum of the first two numbers
        int sum = num1 + num2;

        // Find the smallest between the sum and the third number
        int smallest = 0;
        if(sum<num3){
            smallest=sum;
        }else{
            smallest=num3;
        }

        // Output results
        System.out.println("The largest of the first two numbers is: " + largest);
        System.out.println("The sum of the first two numbers is: " + sum);
        System.out.println("The smallest between the sum and the third number is: " + smallest);
    }
}
