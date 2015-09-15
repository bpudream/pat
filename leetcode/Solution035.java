package leetcode;

/**
 * Created by bpudream on 15-09-15.
 */
public class Solution035 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        int mid;
        while (start <= end) {
            if (start == end) {
                res = start;
                if (target > nums[res]) {
                    res++;
                }
                break;
            }
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                res = mid;
                break;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (res == -1){
            res = start;
        }

        return res;
    }
}

/*
* Given a sorted array and a target value, return the index if the target is found.
* If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
* */
