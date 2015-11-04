package leetcode;

/**
 * Created by bpudream on 15-11-04.
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        int counter[] = new int[32];
        for(int n : nums) {
            for(int i = 0; i < 32; i++) {
                counter[i] += (n >> i) & 1;
            }
        }
        int res = 0;
        for(int j = 0; j < 32; j++) {
            res += (counter[j] % 3) << j;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution137 sol = new Solution137();
        int[] nums = {1,1,1,2,3,3,3};
        System.out.println(sol.singleNumber(nums));
    }
}

/*
* Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* */