/**
 * Created by bpudream on 15-07-16.
 */
public class Solution028 {
    public int strStr(String haystack, String needle) {
        int nlen = needle.length();
        if(nlen == 0)
            return 0;
        if(nlen > haystack.length())
            return -1;
        int res = -1;
        int start = -1; // searching start index
        boolean flag = false; // in searching
        int nindex = 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(flag) {
                if(haystack.charAt(i) == needle.charAt(nindex)) {
                    nindex++;
                    if(nindex == nlen) {
                        res = start;
                        break;
                    }
                }
                else {
                    nindex = 0;
                    flag = false;
                    i = start;
                }
            }
            else {
                if(haystack.charAt(i) == needle.charAt(0)) {
                    flag = true;
                    start = i;
                    nindex = 1;
                    if(nindex == nlen) {
                        res = start;
                        break;
                    }
                }
            }
        }

        return res;
    }
}

/**
 * Implement strStr()
 *
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 1 function RabinKarp(string s[1..n], string pattern[1..m])
 2 hpattern := hash(pattern[1..m]);  hs := hash(s[1..m])
 3 for i from 1 to n-m+1
 4   if hs = hpattern
 5     if s[i..i+m-1] = pattern[1..m]
 6       return i
 7   hs := hash(s[i+1..i+m])
 8 return not found
 */

