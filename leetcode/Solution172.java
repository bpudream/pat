/**
 * Created by David on 2015/11/8.
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n > 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }
}

/*
* Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
* */