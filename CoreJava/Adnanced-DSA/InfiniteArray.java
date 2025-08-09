import java.util.*;

class InfiniteArray{

    public static void main(String ...args){
        int []arr = {2,3,5,6,7,8,9,10,11,12,15,20,21,23,30,45,50,53,59,66,70,73,79,82,88,90,91,95,99,100};
        int target = Integer.parseInt(args[0]); // var-args take value from terminal while execution
        System.out.println(ans(arr, target));
    }

    static int ans(int[] arr, int target){
        // 1st find the range
        // Start with a box size of 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while(target > arr[end]){
            int newStart = end + 1; // start is still needed so for temporary storage this new start is used...

            // double the box value
            end = end + (end - start + 1) * 2; // newEnd = previousEnd + sizeOfBox * 2
            start = newStart;
        }

        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){
            int mid = start + (end - start)/2;

            if(target < arr[mid])
            end = mid - 1;
            else if(target > arr[mid])
            start = mid + 1;
            else
            return mid;
        }
        return -1;
    }
}