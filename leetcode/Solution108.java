/**
 * Created by bpudream on 15-06-26.
 */

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int init, int length) {
        if(length < 1)
            return null;
        int n = length;
        int level = (int)(Math.log(n + 1) / Math.log(2));
        int upper = (int)Math.pow(2, level) - 1;
        int lower = upper + 1;
        int leaves = n - upper;

        int left, right;
        if(leaves <= lower / 2) {
            right = (upper - 1) / 2;
            left = right + leaves;
        }
        else {
            left = (upper - 1) / 2 + lower / 2;
            right = (upper - 1) / 2 + leaves - lower / 2;
        }

        TreeNode root = new TreeNode(nums[init + left]);
        root.left = buildTree(nums, init, left);
        root.right = buildTree(nums, init + left + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Solution108 sol = new Solution108();
        int inorder[] = {1,2,3,4,5,6,7,8,9};
        TreeNode root = sol.sortedArrayToBST(inorder);

    }
}

/**
 * Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */