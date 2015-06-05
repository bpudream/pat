/**
 * Created by David on 2015/6/5.
 */
import java.util.Stack;
public class Solution101 {

    boolean compareTrees(TreeNode l, TreeNode r) {
        if(l == null && r == null)
            return true;
        else if(l == null || r == null)
            return false;
        if(l.val != r.val)
            return false;
        else
            return compareTrees(l.left, r.right) && compareTrees(r.left, l. right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        boolean res = true;

        res = compareTrees(root, root);

        return res;
    }

    public static void main(String[] args) {
        Solution101 sol = new Solution101();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(2);

//        root = null;

        System.out.println(sol.isSymmetric(root));
    }
}

/**
 * Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */