package leetcode;

/**
 * Created by bpudream on 15-11-09.
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == n) {
            return m;
        }

        int t = m;
        int diff = n - m;
        int digits = 0;
        do {
            digits++;
            t = t >> 1;
        } while(t > 0);

        if((n >> digits) > 0) {
            return 0;
        }

        int diffCount = 0;
        while(diff > 0) {
            diffCount++;
            diff = diff >> 1;
        }
        int res = (m >> diffCount) << diffCount;

        int[] a = new int[32];
        m = res;
        for(int i = 0; i < 32; i++) {
            a[i] = ((m >> i) & 1) & ((n >> i) & 1);
        }
        res = 0;
        for(int i = 31; i >= 0; i--) {
            res = (res << 1) + a[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution201 sol = new Solution201();

        System.out.println(sol.rangeBitwiseAnd(11, 12));
    }
}

/*
* Given a range [m, n] where 0 <= m <= n <= 2147483647, r
* eturn the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.


* */