import java.util.*;

class DuplicateNumber{
    public static void main(String ...args){
        int[] arr = {1,3,4,2,2};
        IO.println(findDuplicate(arr));
        int[] arr1 = {3,1,3,4,2};
        IO.println(findDuplicate(arr1));
        int[] arr2 = {3,3,3,3,3};
        IO.println(findDuplicate(arr2));
        int[] arr3 = {1,3,4,2,1};
        IO.println(findDuplicate(arr3));
    }

    static int findDuplicate(int[] arr){
        int i=0;
        while(i < arr.length){
            if(arr[i] != i+1){
                int correctIndex = arr[i] - 1;
                if(arr[i] != arr[correctIndex]){
                    swap(arr, i, correctIndex);
                }
                else{
                    return arr[i];
                }
            }
            else{
                i++;
            }
        }
        return -1;
    }

    static void swap(int[] arr, int i, int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}