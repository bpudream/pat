package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by bpudream on 15-11-23.
 */
public class MyStack {
    Queue<Integer> queue;
    int first;

    public MyStack() {
        queue = new ArrayDeque<>();
        first = -255;
    }

    // Push element x onto stack.
    public void push(int x) {
        first = x;
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> nq = new ArrayDeque<>();
        int t = -511;
        while(queue.size() > 1) {
            t = queue.remove();
            nq.add(t);
        }
        first = t;
        queue = nq;

    }

    // Get the top element.
    public int top() {
        return first;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

/*
* Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
* */