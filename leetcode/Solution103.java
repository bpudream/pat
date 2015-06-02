/**
 * Created by bpudream on 15-06-02.
 */
import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean lefting = true;

        Stack<TreeNode> stackleft = new Stack<>();
        Stack<TreeNode> stackright = new Stack<>();
        Stack<TreeNode> source, target;

        if(root != null)
            stackleft.push(root);

        while(!stackleft.empty() || !stackright.empty()) {
            if(lefting) {
                source = stackleft;
                target = stackright;
            }
            else {
                source = stackright;
                target = stackleft;
            }

            List<Integer> sublist = new ArrayList<>();
            while(!source.empty()) {
                TreeNode t = source.pop();

                sublist.add(t.val);
                if(lefting) {
                    if(t.left != null)
                        target.push(t.left);
                    if(t.right != null)
                        target.push(t.right);
                }
                else {
                    if(t.right != null)
                        target.push(t.right);
                    if(t.left != null)
                        target.push(t.left);
                }
            }

            res.add(sublist);

            lefting = !lefting;
        }

        return res;
    }

    public static void main(String[] args) {

        Solution103 sol = new Solution103();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);

        root = null;

        List<List<Integer>> res = sol.zigzagLevelOrder(root);
        for(List<Integer> sub : res) {
            System.out.println(sub.toString());
        }
    }
}
