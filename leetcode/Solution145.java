/**
 * Created by bpudream on 15-06-25.
 */
import java.util.*;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> visited = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root != null) {
            stack.push(root);
            visited.push(0);
        }
        while(!stack.empty()) {
            int counter = visited.pop();
            TreeNode t = stack.peek();
            if(counter == 0) {
                visited.push(++counter);
                if(t.left != null) {
                    stack.push(t.left);
                    visited.push(0);
                }
            }
            else if(counter == 1) {
                visited.push(++counter);
                if(t.right != null) {
                    stack.push(t.right);
                    visited.push(0);
                }
            }
            else {
                stack.pop();
                res.add(t.val);
            }
        }

        return res;
    }
}


/**
 * Binary Tree Postorder Traversal
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 */