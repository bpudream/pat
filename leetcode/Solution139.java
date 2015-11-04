package leetcode;

import java.util.Set;
import java.util.Stack;

/**
 * Created by bpudream on 15-11-04.
 */
public class Solution139 {
    public boolean wordBreak(String s, Set<String> set) {
        int hash[] = new int[s.length()];
        return build(s, 0, set, hash);
    }

    private boolean build(String s, int start, Set<String> set, int[] hash) {
        int n = s.length();
        boolean res = false;

        if(start == n) {
            return true;
        }

        if(hash[start] != 0) {
            return hash[start] == 1;
        }

        int end = start;

        while(end < n) {
            String sub = s.substring(start, end + 1);
            if(set.contains(sub)) {
                boolean rest = build(s, end + 1, set, hash);
                if(rest) {
                    return true;
                }
            }
            end++;
        }

        if(res) {
            hash[start] = 1;
        }
        else {
            hash[start] = -1;
        }
        return res;
    }
}

/*
* Given a string s and a dictionary of words dict,
* determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
* */