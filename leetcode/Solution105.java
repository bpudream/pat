/**
 * Created by bpudream on 15-06-17.
 */
public class Solution105 {
    private TreeNode buildTreeLocal(int[] preorder, int start, int[] inorder, int first, int last) {
//        System.out.println("first: " + first + " last: " + last + " start: " + start);
        if(first > last)
            return null;
        TreeNode root = new TreeNode(preorder[start]);
//        System.out.println(root.val);
        int i = first;
        for(; i <= last; i++) {
            if(preorder[start] == inorder[i])
                break;
        }
        root.left = buildTreeLocal(preorder, start + 1, inorder, first, i - 1);
        root.right = buildTreeLocal(preorder, start + i - first + 1, inorder, i + 1, last);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeLocal(preorder, 0, inorder, 0, preorder.length - 1);
    }

    public static void main(String[] args) {
        Solution105 sol = new Solution105();
//        int[] b = {8,4,9,2,5,1,6,3,7};
//        int[] a = {1,2,4,8,9,5,3,6,7};
        int[] a = {2,1,3};
        int[] b = {1,2,3};
        TreeNode root = sol.buildTree(a, b);
        TreeNode.printTree(root);
    }
}

/**
 *  Construct Binary Tree with Preorder and Inorder traversal
 *
 *  Given preorder and inorder traversal of a tree, construct the binary tree.
 */

