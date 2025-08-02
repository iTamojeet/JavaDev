import java.util.*;

class RotationCount{
    public static void main(String []args){
        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println("The array is rotated "+countRotations(arr)+" times.");
        int[] arr1 = {0,1,2,3,4,5,6,7};
        System.out.println("The array is rotated "+countRotations(arr1)+" times.");
        int[] arr2 = {4,4,5,5,5,6,7,7,7,0,1,2,3};
        System.out.println("The array is rotated "+countRotations(arr2)+" times.");
    }

    static int countRotations(int[] arr){
        int pivot = findPivot(arr);
        return pivot + 1;
    }

    // this will not work for duplicate values!!!😔
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            // 4 cases over here...
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // // this will work for duplicate values!!!☺️
    // static int findPivotWithDuplicates(int[] arr){
    //     int start = 0;
    //     int end = arr.length - 1;
    //     while(start <= end){
    //         int mid = start + (end - start)/2;
    //         // 4 cases over here...
    //         if(mid < end && arr[mid] > arr[mid+1]){
    //             return mid;
    //         }
    //         if(mid > start && arr[mid] < arr[mid-1]){
    //             return mid-1;
    //         }
            
    //         // if elements at middle, start, end are equal then just skip the duplicates
    //         if(arr[mid] == arr[start] && arr[mid] == arr[end]){
    //             // skip the duplicates
    //             // NOTE: what if the elements at start and end were the actual pivot?
    //             // check if start is pivot
    //             if(start < end && arr[start] > arr[start + 1]){
    //                 return start;
    //             }
    //             start++;
    //             //check whether end is pivot
    //             if(end > start && arr[end] < arr[end - 1]){
    //                 return end - 1;
    //             }
    //             end--;
    //         }
    //         // left side is sorted, so pivot should be in the right
    //         else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
    //             start = mid + 1;
    //         }
    //         else{
    //             end = mid - 1;
    //         }
    //     }
    //     return -1;
    // }
}