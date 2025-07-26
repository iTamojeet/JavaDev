import java.util.*;

class NextGreatestLetter{
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(target < letters[mid])
            end = mid - 1;
            else
            start = mid + 1;
        }
        /*
        % operator ensures that if we ever reach the end of the array
        and the target is still not found yet then it will always return
        the 1st element in that array as letters wrap around the array
        */
        return letters[start % letters.length];
    }

    public static void main(String []args){
        char []arr1 = {'x','x','x','y'};
        char []arr2 = {'a','b','f','g'};
        char target = 'e';
        System.out.println(nextGreatestLetter(arr2, target));
    }
}