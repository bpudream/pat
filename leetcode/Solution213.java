/**
 * Created by David on 2015/11/17.
 */
public class Solution213 {
    public int rob(int[] a) {
        int n = a.length;
        if(n < 1) {
            return 0;
        }
        if(n == 1) {
            return a[0];
        }
        return maxRob(a, 0, n - 2) > maxRob(a, 1, n - 1) ? maxRob(a, 0, n - 2) : maxRob(a, 1, n - 1);
    }

    private int maxRob(int[] a, int start, int end) {
        if(end < start) {
            return 0;
        }
        if(end == start) {
            return a[start];
        }
        int n = end + 1;
        int[] max = new int[n];
        // int res = 0;
        if(n > start) {
            max[start] = a[start];
        }
        if(n > start + 1) {
            if(a[start + 1] > a[start]) {
                max[start + 1] = a[start + 1];
            }
            else {
                max[start + 1] = max[start];
            }
        }
        if(n > start + 2) {
            if(a[start] + a[start + 2] > a[start + 1]) {
                max[start + 2] = a[start] + a[start + 2];
            }
            else {
                max[start + 2] = a[start + 1];
            }
        }
        if(n > start + 3) {
            for(int i = start + 3; i <= end; i++) {
                if(max[i - 2]> max[i - 3]) {
                    max[i] = max[i - 2] + a[i];
                }
                else {
                    max[i] = max[i - 3] + a[i];
                }
            }
        }
        return max[end] > max[end - 1] ? max[end] : max[end - 1];
    }
}

/*
* After robbing those houses on that street,
* the thief has found himself a new place for his thievery so that he will not get too much attention.
* This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
  * the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.
* */