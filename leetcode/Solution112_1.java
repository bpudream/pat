import java.util.Stack;

/**
 * Created by bpudream on 15-06-17.
 */
public class Solution112_1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> flags = new Stack<>();
        stack.push(root);
        flags.push(false);
        while(root.left != null) {
            root = root.left;
            stack.push(root);
            flags.push(false);
        }
        while(!stack.empty()) {
            TreeNode t = stack.peek();
            if(t.left == null && t.right == null) {
                Stack<TreeNode> s = (Stack<TreeNode>)stack.clone();
                int mysum = 0;
                while(!s.empty()) {
                    mysum += s.pop().val;
                }
                if(mysum == sum)
                    return true;
                stack.pop();
                flags.pop();
            }
            else if(t.right != null) {
                if(flags.pop()) {
                    stack.pop();
                }
                else {
                    flags.push(true);
                    root = t.right;
                    stack.push(root);
                    flags.push(false);
                    while(root.left != null) {
                        root = root.left;
                        stack.push(root);
                        flags.push(false);
                    }
                }
            }
            else {
                stack.pop();
                flags.pop();
            }
        }
        return false;
    }
}


/**
 * Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a
 * root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */