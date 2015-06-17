import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bpudream on 15-06-17.
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        int level = 0;

        while(!queue.isEmpty()) {
            int nextcounter = 0;
            while(counter > 0) {
                TreeNode t = queue.remove();
                if(t.left != null) {
                    queue.add(t.left);
                    nextcounter++;
                }
                if(t.right != null) {
                    queue.add(t.right);
                    nextcounter++;
                }
                counter--;
            }
            counter = nextcounter;
            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        Solution104 sol = new Solution104();
        TreeNode root = new TreeNode(0);
        root = null;
        System.out.println(sol.maxDepth(root));
    }
}