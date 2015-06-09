/**
 * Created by bpudream on 15-06-08.
 */
import java.util.*;

public class Solution110 {
    private int getDepth(TreeNode root, ArrayList<TreeNode> list, ArrayList<Integer> depthTable) {
        if(root == null)
            return 0;
        int index = list.indexOf(root);
        if(depthTable.get(index) > 0)
            return depthTable.get(index);
        int left = getDepth(root.left, list, depthTable);
        int right = getDepth(root.right, list, depthTable);
        int depth =  left > right ? left : right;
        depth++;
        depthTable.set(index, depth);
        return depth;
    }

    private void generateList(TreeNode root, List<TreeNode> list) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        if(root == null)
            return;
        list.add(root);
        q1.add(root);
        boolean isQueue1 = true;

        while(!q1.isEmpty() || !q2.isEmpty()) {
            Queue<TreeNode> source, target;
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
                    list.add(t.left);
                }
                if(t.right != null) {
                    target.add(t.right);
                    list.add(t.right);
                }
            }

            isQueue1 = !isQueue1;
        }
    }

    ArrayList<TreeNode> list = new ArrayList<>();
    ArrayList<Integer> depthTable = new ArrayList<>();
    boolean init = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        boolean res = true;

        if(init) {
            init = false;
            generateList(root, list);
            for (int i = 0; i < list.size(); i++) {
                depthTable.add(-255);
            }
            getDepth(root, list, depthTable);
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        int leftIndex = list.indexOf(root.left);
        int rightIndex = list.indexOf(root.right);

        if(root.left == null) {
            if(depthTable.get(rightIndex) > 1)
                res = false;
        }
        else if(root.right == null) {
            if(depthTable.get(leftIndex) > 1)
                res = false;
        }
        else if(Math.abs(depthTable.get(leftIndex) - depthTable.get(rightIndex)) > 1) {
            res = false;
        }
        else {
            res = isBalanced(root.left) & isBalanced(root.right);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(6);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(25);

        root = null;

        Solution110 sol = new Solution110();
        System.out.println(sol.isBalanced(root));
    }
}
