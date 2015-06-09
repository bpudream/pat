/**
 * Created by bpudream on 15-06-08.
 */
import java.util.*;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<TreeNode> stack = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        int lastIndex = 0;
        if(root == null)
            return res;

        stack.add(root);
        visited.add(0);
        TreeNode t = root;
        while(t.left != null) {
            t = t.left;
            stack.add(++lastIndex, t);
//            System.out.println("add: " + t.val);
            visited.add(0);
        }

        while(!stack.isEmpty()) {
            t = stack.get(lastIndex);
            if(t.right == null) {
                if(t.left == null) {
                    int tsum = 0;
                    List<Integer> list = new ArrayList<>();
                    for(int i = 0; i <= lastIndex; i++) {
                        int value = stack.get(i).val;
                        list.add(value);
                        tsum += value;
                    }
                    if(tsum == sum)
                        res.add(list);
                }
                stack.remove(lastIndex);
                visited.remove(lastIndex--);
            }
            else {
                if(visited.get(lastIndex) == 1) {
                    stack.remove(lastIndex);
                    visited.remove(lastIndex--);
                }
                else {
                    visited.set(lastIndex, 1);
                    t = t.right;
                    stack.add(++lastIndex, t);
//                    System.out.println("add: " + t.val);
                    visited.add(0);
                    while (t.left != null) {
                        t = t.left;
                        stack.add(++lastIndex, t);
//                        System.out.println("add: " + t.val);
                        visited.add(0);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(-13);
        root.right.right = new TreeNode(25);

//        root = null;

        Solution113 sol = new Solution113();
        List<List<Integer>> res = sol.pathSum(root, 15);
        for(List<Integer> list : res) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}


/**
 * Path Sum II
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
