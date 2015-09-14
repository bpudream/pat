package leetcode;

import java.util.HashMap;

/**
 * Created by bpudream on 15-05-30.
 */
public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }

    public int[] twoSumHash(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int seek = target - nums[i];
            Integer t = hashMap.get(seek);
            if(t != null && t > i) {
                res[0] = i;
                res[1] = t;
            }
        }

        return res;
    }
}

/**
 * Tow sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2.
 Please note that your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */