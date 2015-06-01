/**
 * Created by bpudream on 15-06-01.
 */
public class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0)
            return head;
        ListNode list = new ListNode(-255);
        list.next = head;
        ListNode pre = list;
        ListNode cur = list;
        for(int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return list.next;
    }
    public static void main(String[] args) {
        Solution019 s = new Solution019();
//        ListNode list = null;
        ListNode list = new ListNode(0);
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
        res = s.removeNthFromEnd(list, 1);
        while(res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
    }
}


/**
 * Remove Nth Node From End of List
 *
* Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
*/
