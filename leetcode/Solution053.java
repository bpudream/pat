package leetcode;

/**
 * Created by bpudream on 15-09-17.
 */
public class Solution053 {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum < 0) {
                sum = 0;
            }
            else {
                if(sum > maxsum) {
                    maxsum = sum;
                }
            }
        }

        return maxsum;
    }
}

/**
 * Maximum Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */