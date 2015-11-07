/**
 * Created by David on 2015/11/7.
 */
public class Solution165 {
    public int compareVersion(String a, String b) {
        return compare(a, 0, b, 0);
    }
    private int compare(String a, int i, String b, int j) {
        int res = 0;

        int m = a.length();
        int n = b.length();

        if(i >= m && j >= n) {
            return 0;
        }
        else if(i >= m) {
            return -dealTail(b.substring(j));
            // return -1;
        }
        else if(j >= n) {
            return dealTail(a.substring(i));
            // return 1;
        }

        int s1 = i;
        while(i < m && a.charAt(i) != '.') {
            i++;
        }
        int v1 = Integer.parseInt(a.substring(s1, i++));

        int s2 = j;
        while(j < n && b.charAt(j) != '.') {
            j++;
        }
        int v2 = Integer.parseInt(b.substring(s2, j++));

        if(v1 > v2) {
            res = 1;
        }
        else if(v1 < v2) {
            res = -1;
        }
        else {
            res = compare(a, i, b, j);
        }

        return res;
    }

    private int dealTail(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0' && s.charAt(i) != '.') {
                res = 1;
                break;
            }
        }
        return res;
    }
}

/*
* Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three",
 it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
* */