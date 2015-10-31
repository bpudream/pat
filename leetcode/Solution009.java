package leetcode;

/**
 * Created by bpudream on 15-10-31.
 */
public class Solution009 {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    private int reverse(int x) {
        int res = 0;
        boolean isNeg = false;
        if(x < 0) {
            x = -x;
            isNeg = true;
        }

        while(x > 0) {
            int t = x % 10;
            // System.out.println(res * 10);
            int mult = res * 10;
            if(mult / 10 != res) {
                return 0;
            }
            res = mult + t;
            x /= 10;
        }
        if(isNeg) {
            res = -res;
        }
        return res;
    }
}
