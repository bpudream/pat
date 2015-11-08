/**
 * Created by David on 2015/11/8.
 */
public class Solution171 {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }
}

/*
* Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
* */