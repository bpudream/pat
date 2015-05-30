/**
 * Created by bpudream on 15-05-30.
 */
public class Solution024 {
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public ListNode swapPairs(ListNode head) {
        ListNode list = new ListNode(-255);
        list.next = head;
        ListNode iter = list;
        while(iter.next != null && iter.next.next != null) {
            ListNode first = iter.next;
            ListNode second = first.next;
            iter.next = second;
            first.next = second.next;
            second.next = first;
            iter = first;
        }
        return list.next;
    }

    public static void main(String[] args) {
        Solution024 s = new Solution024();
        ListNode list = new ListNode(0);
        ListNode l1 = new ListNode(1);
        list.next = l1;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(3);
        l1 = l1.next;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(5);
        l1 = l1.next;
        l1.next = new ListNode(6);
        l1 = l1.next;
        l1.next = new ListNode(7);
        l1 = l1.next;

        ListNode res = list;
        while(res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println();
        res = s.swapPairs(list);
        while(res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
    }
}


/**
 * Swap nodes in pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
*/