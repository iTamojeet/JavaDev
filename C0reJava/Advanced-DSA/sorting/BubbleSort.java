import java.util.*;

class BubbleSort{
    public static void main(String ...args){
        int[] arr = {3,1,5,4,2};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr){
        // run the steps n-1 times
        for(int i=0; i<arr.length; i++){
            // for each step, max element will come @ the last respective index
            for(int j=1; j<=arr.length-i-1; j++){
                // swap if the item is smaller than the pervious item
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}