package leetcode;

/**
 * Created by bpudream on 15-11-03.
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        boolean res = true;
        s = s.toLowerCase();
        while(start < end) {
            char a = s.charAt(start);
            char b = s.charAt(end);
            if(!(a >= 'a' && a <= 'z' || a >= '0' && a <= '9')) {
                start++;
                continue;
            }
            if(!(b >= 'a' && b <= 'z' || b >= '0' && b <= '9')) {
                end--;
                continue;
            }
            if(s.charAt(start++) != s.charAt(end--)) {
                res = false;
                break;
            }
        }
        return res;
    }
}

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */