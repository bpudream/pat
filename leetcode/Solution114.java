import java.util.ArrayList;

/**
 * Created by bpudream on 15-06-19.
 */
public class Solution114 {
    int index = 0;
    private void traversal(TreeNode root, ArrayList<TreeNode> list) {
        if(root == null)
            return;
        list.add(index++, root);
        traversal(root.left, list);
        traversal(root.right, list);
    }
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        traversal(root, list);
        System.out.println(index);
        for(int i = 0; i < index - 1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }
    }
    public static void main(String[] args) {
        Solution114 sol = new Solution114();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        sol.flatten(root);
    }
}

/**
 * Flatten Binary Tree to Linked List
 *
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */