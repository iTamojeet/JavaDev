import java.util.*;

// https://leetcode.com/problems/missing-number/?envType=problem-list-v2&envId=array
// Amazon Question

class MissingNumber{
    public static void main(String ...args){
        int[] arr = {0,1,3,4,2};
        IO.println(missingNumber(arr));
    }

    static int missingNumber(int[] arr){
        int i=0;
        while(i < arr.length){
            int correctIndex = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correctIndex]){
                swap(arr, i, correctIndex);
            }
            else{
                i++;
            }
        }

        // search for 1st missing number
        for(int index=0; index < arr.length; index++){
            if(arr[index] != index){
                return index;
            }
        }

        // case 2
        return arr.length;
    }

    static void swap(int[] arr, int i, int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

    // subtract sum of actual array with given array to get missing element...
    /*
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum2;
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        sum2 = (n*(n+1))/2;
        return sum2-sum;
    }
    */
}