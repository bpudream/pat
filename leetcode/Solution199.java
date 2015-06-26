/**
 * Created by bpudream on 15-06-26.
 */
import java.util.*;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int counter = 0;
        if(root != null) {
            queue.add(root);
            counter++;
        }

        while(!queue.isEmpty()) {
            int next = 0;
            TreeNode t = null;
            while(counter > 0) {
                t = queue.remove();
                counter--;
                if(t.left != null) {
                    next++;
                    queue.add(t.left);
                }
                if(t.right != null) {
                    next++;
                    queue.add(t.right);
                }
            }
            counter = next;
            if(t != null)
                res.add(t.val);
        }

        return res;
    }
}


/**
 * Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */