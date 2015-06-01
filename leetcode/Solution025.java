/**
 * Created by bpudream on 15-06-01.
 */
public class Solution025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 1) {
            return head;
        }
        ListNode res = new ListNode(-255);
        ListNode resTailMark = res;
        ListNode sub = new ListNode(-255);
        ListNode list = new ListNode(-127);
        list.next = head;
        while(list.next != null) {
            ListNode tail = list.next;
            int i;
            for(i = 0; i < k && list.next != null; i++) {
                ListNode iter = list.next;
                list.next = iter.next;
                ListNode subhead = sub.next;
                sub.next = iter;
                iter.next = subhead;
            }

            if(i < k) {
                sub.next = reverseKGroup(sub.next, i);
            }

            resTailMark.next = sub.next;
            sub.next = null;
            resTailMark = tail;
        }

        return res.next;
    }

    public static void main(String[] args) {
        Solution025 s = new Solution025();
        ListNode list = null;
//        ListNode list = new ListNode(0);
//        ListNode l1 = new ListNode(1);
//        list.next = l1;
//        l1.next = new ListNode(2);
//        l1 = l1.next;
//        l1.next = new ListNode(3);
//        l1 = l1.next;
//        l1.next = new ListNode(4);
//        l1 = l1.next;
//        l1.next = new ListNode(5);
//        l1 = l1.next;
//        l1.next = new ListNode(6);
//        l1 = l1.next;
//        l1.next = new ListNode(7);
//        l1 = l1.next;

        ListNode res = list;
        while(res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println();
        res = s.reverseKGroup(list, 3);
        while(res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
    }

}


/**
 * Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
