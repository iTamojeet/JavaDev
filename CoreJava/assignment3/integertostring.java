class IntegerToString {
    public static void main(String[] args) {
        int[] intArray = {10, 20, 30, 40, 50};
        
        String[] stringArray = new String[intArray.length];
        
        for (int i = 0; i < intArray.length; i++) {
            stringArray[i] = String.valueOf(intArray[i]);
        }
        
        System.out.println("Converted String Array:");
        for (String str : stringArray) {
            System.out.println(str);
        }
    }
}
