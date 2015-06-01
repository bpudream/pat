/**
 * Created by bpudream on 15-06-01.
 */
import java.util.*;

public class Solution094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        if(root != null)
            stack.push(root);
        while(!stack.empty()) {
            TreeNode head = stack.peek();
            if(head.left != null && !visited.contains(head.left)) {
                stack.push(head.left);
            }
            else {
                head = stack.pop();
                visited.add(head);
                res.add(head.val);
                if(head.right != null) {
                    stack.push(head.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        TreeNode root = null;
        Solution094 sol = new Solution094();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;


        sol.inorderTraversal(t1);
    }
}


/**
 * Binary Tree Inorder Traversal
 */