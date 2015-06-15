/**
 * Created by bpudream on 15-06-15.
 */
public class Solution109 {
    private TreeNode getTree(ListNode head, int length) {
        if(length == 0)
            return null;
        int mid = length / 2 + 1;
        ListNode node = head;
        for(int i = 1; i < mid; i++) {
            node = node.next;
        }
        TreeNode root = new TreeNode(node.val);
        root.left = getTree(head, mid - 1);
        root.right = getTree(node.next, length - mid);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int counter = 0;
        ListNode list = head;
        while(list != null) {
            counter++;
            list = list.next;
        }
        TreeNode res = getTree(head, counter);

        return res;
    }


    public static void main(String[] args) {
        Solution109 sol = new Solution109();
        int arr[] = {1, 2};
//        int arr[] = {1,2,3,4,5,6};
        ListNode list = ListNode.createList(arr);
//        list = null;

        TreeNode root = sol.sortedListToBST(list);
        TreeNode.printTree(root);
    }
}


/**
 * Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */