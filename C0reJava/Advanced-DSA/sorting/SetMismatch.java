import java.util.*;

// https://leetcode.com/problems/set-mismatch/?envType=problem-list-v2&envId=array

class SetMismatch {
    public static void main(String ...args){
        int[] arr = {1,2,2,4};
        IO.println(Arrays.toString(findErrorNums(arr)));
        int[] arr1 = {1,1};
        IO.println(Arrays.toString(findErrorNums(arr1)));
    }
    public static int[] findErrorNums(int[] arr) {
        int i=0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                swap(arr, i, correctIndex);
            }
            else{
                i++;
            }
        }

        // search for 1st missing number
        for(int index=0; index < arr.length; index++){
            if(arr[index] != index + 1){
                return new int[] {arr[index], index+1};
            }
        }

        // case 2
        return new int[] {-1, -1};
    }

    static void swap(int[] arr, int i, int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}