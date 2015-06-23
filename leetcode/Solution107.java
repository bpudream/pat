import java.util.*;

/**
 * Created by David on 2015/6/23.
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int counter = 0;
        if(root != null) {
            queue.add(root);
            counter++;
        }
        while(!queue.isEmpty()) {
            int next = 0;
            list = new ArrayList<>();
            while(counter > 0) {
                TreeNode t = queue.remove();
                counter--;
                list.add(t.val);
                if(t.left != null) {
                    next++;
                    queue.add(t.left);
                }
                if(t.right != null) {
                    next++;
                    queue.add(t.right);
                }
            }
            stack.push(list);
            counter = next;
        }

        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }
}


/**
 * Binary Tree Level Order Traversal II
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */