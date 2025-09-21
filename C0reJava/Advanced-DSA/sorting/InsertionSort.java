import java.util.*;

class InsertionSort{
    public static void main(String ...args){
        int[] arr = {3,1,5,4,2};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertion(int[] arr){
        for(int i=0; i<=arr.length - 2; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j] < arr[j-1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
    }
}