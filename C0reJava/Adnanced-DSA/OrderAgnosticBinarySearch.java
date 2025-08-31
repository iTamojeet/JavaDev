import java.util.*;

class BinarySearch{
    static int orderAgnosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
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
        int []arr1 = {2,4,9,10,12,14,18,19};
        int []arr2 = {100,55,49,33,29,20,19,17,16,15,13,11,9,8,7,3,1,0};
        int target = 19;
        if(orderAgnosticBinarySearch(arr2, target) == -1){
            System.out.println("Not found!!!");
        }
        else{
            System.out.println(target +" Found!!!");
        }
    }
}