/**
 * Created by David on 2015/6/7.
 */
import java.util.Stack;
public class Solution099 {
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(root.left != null) {
            root = root.left;
            stack.push(root);
        }

        TreeNode swap1 = null, swap2 = null;
        TreeNode pre = stack.peek();
        int last = pre.val;
        int err = 0;

        while(!stack.empty()) {
            TreeNode tn = stack.pop();
//            System.out.println(tn.val);
            if(tn.val < last) {
                if(err == 0) {
                    swap1 = pre;
                    swap2 = tn;
                    err++;
                    last = tn.val;
                    pre = tn;
                }
                else if(err == 1) {
                    swap2 = tn;
                    break;
                }
            }
            else {
                last = tn.val;
                pre = tn;
            }
            if(tn.right != null) {
                root = tn.right;
                stack.push(root);
                while(root.left != null) {
                    root = root.left;
                    stack.push(root);
                }
            }
        }

        if(err != 0) {
//            System.out.println("swap: " + swap1.val + " " + swap2.val);
            int temp = swap1.val;
            swap1.val = swap2.val;
            swap2.val = temp;
        }
    }


    public static void main(String[] args) {
        Solution099 sol = new Solution099();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(15);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(25);

//        root = null;

        sol.recoverTree(root);
        sol.recoverTree(root);
    }
}

/**
 * Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.
 */