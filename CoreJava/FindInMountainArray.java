import java.util.*;

class MountainArray{

    static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBinarySearch(arr, target , 0, peak);
        if(firstTry != -1){
            return firstTry;
        }
        // try to search in second half
        return orderAgnosticBinarySearch(arr, target, peak+1, arr.length-1);
    }

    static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                /* We are in the descending part of the array
                this might be hte answer, but to confirm 
                look at the left
                this is why end != mid - 1;
                */
               end = mid;
            }
            else{
                // we r in the ascending part of the array
                start = mid + 1; // because we know mid + 1 element > mid element
            }
        }
        return start; // or return end as both are same... :)
    }

    static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end){

        boolean isAsc = arr[start]<arr[end];

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(isAsc){
                if(target < arr[mid])
                end = mid - 1;
                else
                start = mid + 1;
            }
            else{
                if(target > arr[mid])
                end = mid - 1;
                else
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String []args){
        int[] arr = {0,1,2,3,5,9,2,1,0};
        System.out.println(arr[peakIndexInMountainArray(arr)]);
    }
}