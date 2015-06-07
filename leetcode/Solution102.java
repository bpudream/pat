/**
 * Created by David on 2015/6/7.
 */
import java.util.*;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resInt = new LinkedList<>();

        if(root == null)
            return resInt;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        boolean isQueue1 = true;

        q1.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        resInt.add(temp);

        while(!q1.isEmpty() || !q2.isEmpty()) {
            Queue<TreeNode> source, target;
            temp = new ArrayList<>();
            if(isQueue1) {
                source = q1;
                target = q2;
            }
            else {
                source = q2;
                target = q1;
            }
            while(!source.isEmpty()) {
                TreeNode t = source.remove();
                if(t.left != null) {
                    target.add(t.left);
                    temp.add(t.left.val);
                }
                if(t.right != null) {
                    target.add(t.right);
                    temp.add(t.right.val);
                }
            }
            if(!temp.isEmpty())
                resInt.add(temp);
            isQueue1 = !isQueue1;
        }

        return resInt;
    }

    public static void main(String[] args) {
        Solution102 sol = new Solution102();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(15);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(25);

        root = null;

        List<List<Integer>> res = sol.levelOrder(root);
        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}


/**
 * Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */