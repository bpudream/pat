package leetcode;

/**
 * Created by bpudream on 15-11-10.
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] a) {
        int res = Integer.MAX_VALUE;
        int n = a.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < n) {
            sum += a[end];
            if(sum < s) {
                end++;
            }
            else {
                while(sum >= s) {
                    if(end - start + 1 < res) {
                        res = end - start + 1;
                    }
                    sum -= a[start++];
                }
                end++;
            }
        }
        if(res == Integer.MAX_VALUE) {
            res = 0;
        }
        return res;
    }
}

/*
* Given an array of n positive integers and a positive integer s,
* find the minimal length of a subarray of which the sum ≥ s.
* If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
* */