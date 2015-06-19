import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bpudream on 15-06-19.
 */
public class Solution116 {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode>  queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        TreeLinkNode t = null;
        while(!queue.isEmpty()) {
            int nextCounter = 0;
            while(counter > 0) {
                t = queue.remove();
                counter--;
                if(t.left != null) {
                    nextCounter++;
                    queue.add(t.left);
                }
                if(t.right != null) {
                    nextCounter++;
                    queue.add(t.right);
                }
                if(!queue.isEmpty())
                    t.next = queue.peek();
            }
            t.next = null;
            counter = nextCounter;
        }
    }

}

/**
 * Populating Next Right Pointers In Each Node
 *
 *Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 * /