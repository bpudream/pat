/**
 * Created by bpudream on 15-06-26.
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}


/**
 * Invert Binary Tree
 *
 * Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */