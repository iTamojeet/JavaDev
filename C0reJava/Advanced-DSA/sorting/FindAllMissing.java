import java.util.*;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?envType=problem-list-v2&envId=array
// Asked in Google

class FindAllMissing{
    public static void main(String ...args){
        int[] arr = {1,1};
        IO.println(findDisappearedNumbers(arr));
        int[] arrNew = {4,3,2,7,8,2,3,1};
        IO.println(findDisappearedNumbers(arrNew));
    }

    static List<Integer> findDisappearedNumbers(int[] nums){
        int i=0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }
            else{
                i++;
            }
        }

        // just find missing numbers
        List<Integer> ans = new ArrayList<>();
        for(int index=0; index < nums.length; index++){
            if(nums[index] != index+1){
                ans.add(index + 1);
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