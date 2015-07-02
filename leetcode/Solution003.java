import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by David on 2015/7/1.
 */
public class Solution003 {
    private int getIndex(String s, char c) {
        int i;
        for(i = 0; i < s.length(); i++) {
            if(c == s.charAt(i))
                return i;
        }
        return -1;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;
        String sub = "";
        int length = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(getIndex(sub, c) != -1) {
                int sublen = end - start + 1;
                if(sublen > length)
                    length = sublen;
                start = start + sub.indexOf(c) + 1;
                end = i;
                sub = s.substring(start, end + 1);
            }
            else {
                end++;
                sub += c;
            }
        }

        int sublen = end - start + 1;
        if(sublen > length)
            length = sublen;
        return length;
    }
}

/**
 * Longest Substring Without Repeating Characters
 *
 Given a string, find the length of the longest substring without repeating characters.
 For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */