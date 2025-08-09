import java.util.*;

class FirstAndLastPosition{
    static int[] searchRange(int[] nums, int target){

        int[] ans = {-1, -1};
        // check for 1st occurence of target
        int start = search(nums, target, true);
        // check for last occurence of target
        int end = search(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    // this function just return the index value of target
    static int search(int[] nums, int target, boolean findStartIndex){

        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(target < nums[mid]){
                end = mid - 1;
            }
            
            else if(target > nums[mid]){
                start = mid + 1;
            }
            
            else{
                ans = mid;
                if(findStartIndex){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            // ~~~ potential ans found
            }
        }
        return ans;
    }

    public static void main(String []args){
        int []arr = {2,4,9,9,9,9,10,12,14,18,18,18,19,19,19};
        int target = 19;
        int []ans = searchRange(arr, target);
        if(ans[0] == -1 && ans[1] == -1){
            System.out.println("Not found!!!");
        }
        else{
            System.out.println("start index of " + target + "(target) is " + ans[0] + " and end index is " + ans[1]);
        }
    }
}