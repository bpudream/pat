/**
 * Created by bpudream on 15-06-25.
 */
import java.util.*;
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        TreeNode t = root;
        stack.push(t);

        while(!stack.isEmpty()) {
            t = stack.pop();
            res.add(t.val);
            if(t.right != null) {
                stack.push(t.right);
            }
            if(t.left != null) {
                stack.push(t.left);
            }
        }

        return res;
    }



}

/**
 * Binary Tree Preorder Traversal
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].
 */