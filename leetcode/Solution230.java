package leetcode;

import java.util.Stack;

/**
 * Created by bpudream on 15-11-25.
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        stack.push(n);
        while(n.left != null) {
            n = n.left;
            stack.push(n);
        }
        int i = 1;
        while(i < k) {
            TreeNode t = stack.pop();
            if(t.right != null) {
                t = t.right;
                stack.push(t);
                while(t.left != null) {
                    t = t.left;
                    stack.push(t);
                }
            }

            i++;
        }

        return stack.pop().val;
    }
}

/*
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
* */