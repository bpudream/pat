package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by bpudream on 15-11-06.
 */
public class Solution155 {
    private ArrayList<Integer> list;
    private int index;
    private int min;
    Stack<Integer> stack;

//    public MinStack() {
//        list = new ArrayList<>();
//        index = 0;
//        min = Integer.MAX_VALUE;
//        stack = new Stack<>();
//        stack.push(min);
//    }

    public void push(int x) {
        list.add(index++, x);
        if(x <= min) {
            min = x;
            stack.push(x);
        }
    }

    public void pop() {
        if(index == 0) {
            return;
        }
        int x = list.remove(--index);
        if(x == min) {
            stack.pop();
            min = stack.peek();
        }
    }

    public int top() {
        return list.get(index - 1);
    }

    public int getMin() {
        return min;
    }
}

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */