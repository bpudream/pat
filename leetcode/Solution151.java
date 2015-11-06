package leetcode;

import java.util.Stack;

/**
 * Created by bpudream on 15-11-06.
 */
public class Solution151 {
    public String reverseWords1(String s) {
        StringBuffer res = new StringBuffer("");
        int n = s.length();
        int i = 0;
        boolean searching = false;
        while(i < n) {
            while(i < n && s.charAt(i) == ' ') {
                i++;
            }
            if(i == n) {
                break;
            }
            res.insert(0, " ");
            int start = i;
            while(i < n && s.charAt(i) != ' ') {
                i++;
            }
            String sub = s.substring(start, i);
            res.insert(0, sub);
        }
        return res.toString().trim();
    }

    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer("");
        int n = s.length();
        int i = 0;

        Stack<String> stack = new Stack<>();

        while(i < n) {
            while(i < n && s.charAt(i) == ' ') {
                i++;
            }
            if(i == n) {
                break;
            }
            int start = i;
            while(i < n && s.charAt(i) != ' ') {
                i++;
            }
            String sub = s.substring(start, i);
            stack.push(sub);
        }

        while(!stack.empty()) {
            res.append(stack.pop());
            res.append(' ');
        }

        return res.toString().trim();
    }
}


/*
* Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
* */
