import java.util.Stack;

/**
 * Created by bpudream on 15-07-16.
 */
public class Solution020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean res = true;
        for(int i = 0; res && i < s.length(); i++) {
            char c = s.charAt(i);
            char p = ' ';
            switch(c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(!stack.empty())
                        p = stack.pop();
                    if(p != '(')
                        res = false;
                    break;
                case ']':
                    if(!stack.empty())
                        p = stack.pop();
                    if(p != '[')
                        res = false;
                    break;
                case '}':
                    if(!stack.empty())
                        p = stack.pop();
                    if(p != '{')
                        res = false;
                    break;
                default:
                    res = false;
                    break;
            }
        }
        if(!stack.isEmpty())
            res = false;
        return res;
    }
}

/**
 * Valid Parentheses
 *
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */