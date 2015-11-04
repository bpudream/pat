package leetcode;

/**
 * Created by bpudream on 15-11-04.
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}

/*
* Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* */