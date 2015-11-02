package leetcode;

/**
 * Created by bpudream on 15-11-02.
 */
public class Solution058 {
    public int lengthOfLastWord(String s) {
        int res = 0;
        String st = s.trim();
        if(st == "") {
            return 0;
        }
        int len = 0;
        for(int i = 0; i < st.length(); i++) {
            if(st.charAt(i) == ' ') {
                if(len > 0) {
                    res = len;
                    len = 0;
                }
            }
            else {
                len++;
            }
        }
        if(len != 0) {
            res = len;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "    ";
        s.trim();
        System.out.println("+" + s + "+");
        System.out.println("+" + s.trim() + "+");
    }
}

/*
* Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
* return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.
* */