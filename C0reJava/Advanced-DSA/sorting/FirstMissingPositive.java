import java.util.*;

// https://leetcode.com/problems/first-missing-positive/description/?envType=problem-list-v2&envId=array

class FirstMissingPositive{
    public static void main(String ...args){
        int[] arr = {1,2,0};
        IO.println(firstMissingPositive(arr));
        int[] arr1 = {3,4,-1,1};
        IO.println(firstMissingPositive(arr1));
        int[] arr2 = {7,8,9,11,12};
        IO.println(firstMissingPositive(arr2));
    }

    public static int firstMissingPositive(int[] arr) {
        int i=0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] > 0 && arr[i] < arr.length && arr[i] != arr[correctIndex]){
                swap(arr, i, correctIndex);
            }
            else{
                i++;
            }
        }

        // search for 1st missing number
        for(int index=0; index < arr.length; index++){
            if(arr[index] != index + 1){
                return index + 1;
            }
        }

        // case 2
        return arr.length + 1;
    }

    static void swap(int[] arr, int i, int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}