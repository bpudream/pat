package leetcode;

/**
 * Created by bpudream on 15-09-14.
 */
public class Solution031 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return;
        }
        int i = n - 1;
        while(i > 0) {
            if(nums[i] > nums[i - 1]) { // target found
                break;
            }
            i--;
        }

        if(i > 0) {
            // swap i - 1 & next smallest
            int j;
            for(j = n - 1; j >= i; j--) {
                if(nums[j] > nums[i - 1]) {
                    break;
                }
            }
            int t = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = t;
        }

        // reverse after i
        reverse(nums, n, i);
    }

    private void reverse(int[] a, int n, int start) {
        int i = start;
        int j = n - 1;
        int t = 0;
        while(i < j) {
            t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }


}

/**
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
/