package leetcode;

import java.util.Stack;

/**
 * Created by bpudream on 15-11-02.
 */
public class Solution071 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        int i = 0;
        int start, end;
        while(i < path.length()) {
            while(i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            if(i == path.length()) {
                break;
            }
            start = i;
            while(i < path.length() && path.charAt(i) != '/') {
                i++;
            }
            end = i;
            String element = path.substring(start, end);
            if(element == "..") {
                stack.pop();
            }
            else if(element == ".") {
                // empty
            }
            else {
                stack.push("/" + element);
            }
        }
        if(stack.empty()) {
            return "/";
        }

        StringBuffer res = new StringBuffer("");
        while(!stack.empty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution071 sol = new Solution071();
        System.out.println(sol.simplifyPath("/.."));
    }
}

/*
* Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
* */