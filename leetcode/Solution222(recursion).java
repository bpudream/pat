import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bpudream on 15-06-26.
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        int[] count = {0};
        count(root, count);
        return count[0];
    }

    private void count(TreeNode root, int[] count) {
        if(root == null)
            return;
        int res = 0;
        int left = 0, right = 0;
        TreeNode tl = root, tr = root;
        while(tl.left != null) {
            left++;
            tl = tl.left;
        }
        while(tr.right != null) {
            right++;
            tr = tr.right;
        }
        if(left == right)
            count[0] +=  (int)Math.pow(2, left + 1) - 1;
        else {
            count[0] +=  1;
            count(root.left, count);
            count(root.right, count);
        }
    }

    public static void main(String[] args) {
        Solution222 sol = new Solution222();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
//        root = null;
        System.out.println(sol.countNodes(root));
    }
}


/**
 * Count Complete Tree Nodes
 *
 * Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last,
 is completely filled, and all nodes in the last level are as far left as possible.
 It can have between 1 and 2^h nodes inclusive at the last level h.
 */