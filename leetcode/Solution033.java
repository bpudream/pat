package leetcode;

/**
 * Created by bpudream on 15-09-15.
 */
public class Solution033 {
    public int search(int[] nums, int target) {
        int res = -1;
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            if(end - start < 5) {
                for(int i = start; i <= end; i++) {
                    if(nums[i] == target) {
                        res = i;
                        break;
                    }
                }
                break;
            }
            int mid = (start + end) / 2;
            if(target >= nums[start]) {
                if(target <= nums[end]) {
                    res = binary(nums, start, end, target);
                    break;
                }
                else {
                    if(nums[mid] < nums[start]) {
                        end = mid - 1;
                    }
                    else {
                        if(target <= nums[mid]) {
                            res = binary(nums, start, mid, target);
                            break;
                        }
                        else {
                            start = mid + 1;
                        }
                    }
                }
            }
            else {
                if(target > nums[end]) {
                    break;
                }
                else {
                    if(nums[mid] > nums[start]) {
                        start = mid + 1;
                    }
                    else {
                        if(target >= nums[mid]) {
                            res = binary(nums, mid, end, target);
                            break;
                        }
                        else {
                            end = mid - 1;
                        }
                    }
                }
            }
        }

        return res;
    }

    private int binary(int[] nums, int start, int end, int target) {
        int res = -1;
        if(start > end || target < nums[start] || target > nums[end]) {
            return  res;
        }

        int mid = (start + end) / 2;
        if(target == nums[mid]) {
            res = mid;
        }
        else if(target < nums[mid]) {
            res = binary(nums, start, mid - 1, target);
        }
        else {
            res = binary(nums, mid + 1, end, target);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution033 sol = new Solution033();
        int[] a = {4,1};
        System.out.println(sol.search(a, 1));
    }
}


/*
* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
* */