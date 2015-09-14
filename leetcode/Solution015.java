package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bpudream on 15-09-14.
 */
public class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n < 3) {
            return res;
        }

        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pre = i + 1;
            int post = n - 1;
            while(pre < post) {
                int sum = nums[pre] + nums[post] + nums[i];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[pre]);
                    list.add(nums[post]);
                    res.add(list);
                    pre++;
                    post--;

                    while(pre < post && nums[pre] == nums[pre - 1]) {
                        pre++;
                    }
                    while(pre < post && nums[post] == nums[post + 1]) {
                        post--;
                    }
                }
                else if(sum < 0) {
                    pre++;
                }
                else {
                    post--;
                }
            }
        }

        return res;
    }
}

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
* */

/**
 * -4 -1 -1
 * 0 1 2
 */