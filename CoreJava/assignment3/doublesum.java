class ReverseAndSumDoubleArray {
    public static void main(String[] args){
        double[] originalArray = {1.1, 4.7, 100.001, 0.004, 9.99};
        double sum = 0.0;
        double[] reversedArray = new double[originalArray.length];
        
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }
        
        System.out.println("Sum of elements:");
        for (int i = 0; i < originalArray.length; i++) {
            sum += originalArray[i];
            System.out.printf("Sum is %.2f%n",sum);
        }
    }
}
