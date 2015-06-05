import sun.reflect.generics.tree.Tree;

/**
 * Created by David on 2015/6/5.
 */
import java.util.ArrayList;
import java.util.List;

public class Solution095 {
    List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end)
            list.add(null);
        for(int i = start; i <= end; i++) {
            List<TreeNode> lefts = buildTree(start, i - 1);
            List<TreeNode> rights = buildTree(i + 1, end);
            for(TreeNode l : lefts)
                for(TreeNode r : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
        }
        return list;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = buildTree(1, n);
        return res;
    }
}


/**
 * Unique Binary Search Trees II
 *
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.
 */