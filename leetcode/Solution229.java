package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpudream on 15-11-23.
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if(n == 0) {
            return res;
        }
        else if(n == 1) {
            res.add(nums[0]);
            return res;
        }
        int a = nums[0], b = a - 1;
        int ca = 1, cb = 0;
        int i = 0;
        for(i = 1; i < n; i++) {
            if(nums[i] != a) {
                b = nums[i];
                cb = 1;
                break;
            }
            else {
                ca++;
            }
        }

        for(i = i + 1; i < n; i++) {
            int x = nums[i];
            if(a == x) {
                ca++;
            }
            else if(b == x) {
                cb++;
            }
            else if(ca == 0) {
                a = x;
                ca++;
            }
            else if(cb == 0) {
                b = x;
                cb++;
            }
            else {
                ca--;
                cb--;
            }
        }
        ca = 0;
        cb = 0;
        for(int x : nums) {
            if(x == a) {
                ca++;
            }
            if(x == b) {
                cb++;
            }
        }

        if(ca > n / 3) {
            res.add(a);
        }
        if(cb > n / 3) {
            res.add(b);
        }
        return res;
    }
}

/*
* Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
* The algorithm should run in linear time and in O(1) space.
* */