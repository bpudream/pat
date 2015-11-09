package leetcode;

/**
 * Created by bpudream on 15-06-26.
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null) {
            return 0;
        }
        count++;
        int leftLevel = level(root.left);
        int rightLevel = level(root.right);
        if(leftLevel == rightLevel) {
            if(leftLevel != 0) {
                count += (2 << (leftLevel - 1)) - 1;
                count += countNodes(root.right);
            }
        }
        else {
            if(rightLevel != 0) {
                count += (2 << (rightLevel - 1)) - 1;
            }
            count += countNodes(root.left);
        }
        return count;
    }
    int level(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int level = 1;
        while(root.left != null) {
            level++;
            root = root.left;
        }
        return level;
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