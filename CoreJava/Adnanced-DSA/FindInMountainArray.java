import java.util.*;

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeakIndex(mountainArr);

        // Search in the increasing part
        int firstTry = binarySearch(mountainArr, target, 0, peak, true);
        if (firstTry != -1) return firstTry;

        // Search in the decreasing part
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    private int findPeakIndex(MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target) return mid;

            if (ascending) {
                if (target < midVal) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target < midVal) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MountainArray mountainArr = new TestMountainArray(new int[]{1, 3, 5, 7, 6, 4, 2});
        int target = 6;
        Solution sol = new Solution();
        int index = sol.findInMountainArray(target, mountainArr);
        System.out.println("Target found at index: " + index);
    }
}

interface MountainArray {
    public int get(int index);
    public int length();
}

// Concrete implementation for testing
class TestMountainArray implements MountainArray {
    private int[] arr;

    public TestMountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}
