/**
 * Created by David on 2015/6/3.
 */
import java.util.Stack;

public class Solution098 {
    public boolean isValidBST(TreeNode root) {
        boolean res = true;
        int previous = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null) {
            stack.push(root);
        }
        else {
            return true;
        }
        while(root.left != null) {
            root = root.left;
            stack.push(root);
        }

        previous = stack.peek().val;
        boolean first = true;

        while(!stack.empty()) {
            TreeNode t = stack.pop();
            if(first) {
                first = false;
            }
            else if(t.val <= previous) {
                return false;
            }
            previous = t.val;
            if(t.right != null) {
                t = t.right;
                stack.push(t);
                while(t.left != null) {
                    t = t.left;
                    stack.push(t);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution098 sol = new Solution098();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);

        //root = null;

        boolean res = sol.isValidBST(root);

            System.out.println(res);

    }
}


/**
 * Validate binary search tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
