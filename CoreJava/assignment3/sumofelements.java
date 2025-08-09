class SumOfElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int sum = sumOfElements(array);
        System.out.println("Sum of array elements is: " + sum);
    }

    static int sumOfElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
