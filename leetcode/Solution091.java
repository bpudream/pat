package leetcode;

/**
 * Created by bpudream on 15-11-03.
 */
public class Solution091 {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) {
            return 0;
        }
        int res[] = new int[n + 1];
        for(int i = 0; i < n; i++) {
            res[i] = -1;
        }
        res[n] = 1;
        res[n - 1] = 1;

        count(s, 0, res);
        return res[0];
    }
    private int count(String s, int n, int[] a) {
        if(n >= s.length()) {
            return 1;
        }

        if(s.charAt(n) == '0') {
            a[n] = 0;
            return 0;
        }

        if(a[n] >= 0) {
            return a[n];
        }

        int sum = count(s, n + 1, a);
        if((s.charAt(n) - '0') * 10 + s.charAt(n + 1) - '0' < 27) {
            sum += count(s, n + 2, a);
        }
        a[n] = sum;
        return sum;
    }
}


/*
* A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
* */