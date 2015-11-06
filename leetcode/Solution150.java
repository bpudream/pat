package leetcode;

import java.util.Stack;

/**
 * Created by bpudream on 15-11-06.
 */
public class Solution150 {
    public int evalRPN(String[] t) {
        int res = 0;
        int i = t.length - 1;
        Stack<String> stack = new Stack<>();

        for(String s : t) {
            if(s.equals("+")) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int val = op1 + op2;
                stack.push("" + val);
            }
            else if(s.equals("-")) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int val = op1 - op2;
                stack.push("" + val);
            }
            else if(s.equals("/")) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int val = op1 / op2;
                stack.push("" + val);
            }
            else if(s.equals("*")) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int val = op1 * op2;
                stack.push("" + val);
            }
            else {
                stack.push(s);
            }
        }

        res = Integer.parseInt(stack.pop());

        return res;
    }
}

/*
* Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
* */