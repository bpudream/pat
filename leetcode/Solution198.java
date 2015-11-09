package leetcode;

/**
 * Created by bpudream on 15-11-08.
 */
public class Solution198 {
    public int rob(int[] a) {
        int n = a.length;
        if(n == 0) {
            return 0;
        }
        int[] res = new int[n];
        if(n > 0) {
            res[0] = a[0];
        }
        if(n > 1) {
            res[1] = a[0] > a[1] ? a[0] : a[1];
        }
        if(n > 2) {
            res[2] = a[0] + a[2] > a[1] ? (a[0] + a[2]) : a[1];
        }
        if(n > 3) {
            for(int i = 3; i < n; i++) {
                res[i] = a[i] + (res[i - 2] > res[i - 3] ? res[i - 2] : res[i - 3]);
            }
        }

        int result = 0;
        if(n == 1) {
            result = res[0];
        }
        else {
            result = res[n - 1] > res[n - 2] ? res[n - 1] : res[n - 2];
        }

        return result;
    }
}

/*
* You are a professional robber planning to rob houses along a street.
* Each house has a certain amount of money stashed,
* the only constraint stopping you from robbing each of them is
* that adjacent houses have security system connected
* and it will automatically contact the police if two adjacent houses were broken into on the same night.
*
* Given a list of non-negative integers representing the amount of money of each house,
* determine the maximum amount of money you can rob tonight without alerting the police.
* */