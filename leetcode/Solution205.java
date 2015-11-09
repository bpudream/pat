package leetcode;

import java.util.HashMap;

/**
 * Created by bpudream on 15-11-09.
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        boolean res = true;
        int n = s.length();
        HashMap<Character, Character> hash = new HashMap<>();
        HashMap<Character, Character> back = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if(hash.containsKey(c)) {
                if(d != hash.get(c)) {
                    res = false;
                    break;
                }
            }
            else if(back.containsKey(d)) {
                res = false;
                break;
            }
            else {
                hash.put(c, d);
                back.put(d, c);
            }
        }
        return res;
    }
}

/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character
while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */