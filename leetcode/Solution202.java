package leetcode;

import java.util.HashSet;

/**
 * Created by bpudream on 15-11-09.
 */
public class Solution202 {
    public boolean isHappy(int n) {
        boolean res = false;
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            String s = "" + n;
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int t = s.charAt(i) - '0';
                sum += t * t;
            }
            n = sum;
            if (set.contains(n)) {
                break;
            }
        }

        if (n == 1) {
            res = true;
        }

        return res;
    }
}

/*
* Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits,
and repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
* */
