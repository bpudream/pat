/**
 * Created by bpudream on 15-06-01.
 */
import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if(root != null) {
            stack.push(root);
            TreeNode t = root;
            while (t.left != null) {
                t = t.left;
                stack.push(t);
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode leftmost = stack.pop();
        int res = leftmost.val;
        if(leftmost.right != null) {
            leftmost = leftmost.right;
            stack.push(leftmost);
            while(leftmost.left != null) {
                leftmost = leftmost.left;
                stack.push(leftmost);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
//        root = null;
        BSTIterator i = new BSTIterator(root);
        while (i.hasNext())
            System.out.println(i.next());
    }
}

/**
 * Binary search tree iterator
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */