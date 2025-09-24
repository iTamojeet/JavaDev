import java.util.*;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/?envType=problem-list-v2&envId=array
// Amazon, Microsoft

class FindAllDuplicates{
    public static void main(String ...args){
        int[] arr = {4,3,2,7,8,2,3,1};
        IO.println(findDuplicates(arr));
        int[] arr1 = {1,1,2};
        IO.println(findDuplicates(arr1));
        int[] arr2 = {1};
        IO.println(findDuplicates(arr2));
    }

    static List<Integer> findDuplicates(int[] arr){
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
        
        // just find duplicate numbers
        List<Integer> ans = new ArrayList<>();
        for(int index=0; index < arr.length; index++){
            if(arr[index] != index+1){
                ans.add(arr[index]);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int i, int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}