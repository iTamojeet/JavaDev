class MiddleArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] result = middle(arr);
        
        System.out.println("\n Old array: \n");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n---------------------------\n");
        System.out.println("\n New array: \n");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    static int[] middle(int[] arr) {
        int size = arr.length - 2; // Size of the new array
        int[] arr1 = new int[size];
        int index = 0; // Index for arr1
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && i != arr.length - 1) { // Exclude first and last elements
                arr1[index++] = arr[i]; // Add to arr1 and increment index
            }
        }
        return arr1;
    }
}
