package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by bpudream on 15-11-19.
 */
public class Solution224 {
    public int calculate(String s) {
        ArrayList<String> postfix = new ArrayList<>();
        Stack<String> opStack = new Stack<>();

        int n = s.length();
        // boolean building = false;
        int i = 0;
        for(i = 0; i < n; i++) {
            int start = i;
            // building = true;
            while(i < n) {
                char c = s.charAt(i);
                if(c >= '0' && c <= '9') {
                    i++;
                }
                else {
                    break;
                }
            }
            String num = s.substring(start, i);
            if(!num.equals("")) {
                postfix.add(num);
            }
            if(i == n) {
                break;
            }
            char c = s.charAt(i);
            switch(c) {
                case '+':
                case '-':
                    if(opStack.empty() || opStack.peek().equals("(")) {
                        // nothing
                    }
                    else {
                        postfix.add(opStack.pop());
                    }
                    opStack.push("" + c);
                    break;
                case '(':
                    opStack.push("" + c);
                    break;
                case ')':
                    while(!opStack.empty()) {
                        String op = opStack.pop();
                        if(op.equals("(")) {
                            break;
                        }
                        else {
                            postfix.add(op);
                        }
                    }
                    break;
                default:
                    break;
            }
        } // build postfix expression list

        while(!opStack.empty()) {
            postfix.add(opStack.pop());
        }

        Stack<Integer> stack = new Stack<>();
        for(String str : postfix) {
            char c = str.charAt(0);
            if(c >= '0' && c <= '9') {
                stack.push(Integer.parseInt(str));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;
                switch(c) {
                    case '+':
                        res = a + b;
                        break;
                    case '-':
                        res = a - b;
                        break;
                }
                stack.push(res);
            }
        }

        int res = 0;
        if(!stack.empty()) {
            res = stack.pop();
        }
        return res;
    }
}

/*
* Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ),
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

* */