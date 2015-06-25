/**
 * Created by bpudream on 15-06-25.
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return subTree(inorder, postorder, 0, 0, inorder.length);
    }
    private TreeNode subTree(int[] inorder, int[] postorder, int init, int post, int length) {
        if(length < 1)
            return null;
        int rt = postorder[post + length - 1];
        TreeNode root = new TreeNode(rt);
        System.out.println(rt);
        int leftlength = 0, rightlength = 0;
        for(int i = init; i < init + length; i++) {
            if(inorder[i] != rt)
                leftlength++;
            else
                break;
        }
        rightlength = length - leftlength - 1;
        root.left = subTree(inorder, postorder, init, post, leftlength);
        root.right = subTree(inorder, postorder, init + leftlength + 1, post + leftlength, rightlength);
        return root;
    }

    public static void main(String[] args) {
        Solution106 sol = new Solution106();
        int inorder[] = {1,2,3,4,5,6,7,8,9};
        int postorder[] = {1,2,5,4,3,7,9,8,6};
        TreeNode root = sol.buildTree(inorder, postorder);

    }
}


/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */