package leetcode;

/**
 * Created by bpudream on 15-10-31.
 */
public class Solution038 {
    public String countAndSay(int n) {
        StringBuffer res = new StringBuffer("");
        if(n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        char c;
        int digit = -1;
        int count = 0;
        for(int i = 0; i < pre.length(); i++) {
            c = pre.charAt(i);
            if(c - '0' == digit) {
                count++;
            }
            else {
                if(count > 0) {
                    res.append(count);
                    res.append(digit);
                }
                digit = c - '0';
                count = 1;
            }
        }
        if(count > 0) {
            res.append(count);
            res.append(digit);
        }
        return res.toString();
    }
}
/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

 */