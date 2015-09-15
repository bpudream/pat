package leetcode;

/**
 * Created by bpudream on 15-09-15.
 */
public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int res[] = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        int left, right;

        left = right = binarySearch(nums, start, end, target);

        while(left != -1) {
            res[0] = left;
            left = binarySearch(nums, start, left - 1, target);
        }
        while(right != -1) {
            res[1] = right;
            right = binarySearch(nums, right + 1, end, target);
        }

        return res;
    }

    private int binarySearch(int[] nums, int i, int j, int target) {
        int res = -1;

        int mid;

        while(i <= j) {
            mid = (i + j) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(target < nums[mid]) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }

        return res;
    }
}

/*
* Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
* */