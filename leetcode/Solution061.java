/**
 * Created by bpudream on 15-05-31.
 */
public class Solution061 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

        public ListNode rotateRight(ListNode head, int k) {
            if(head == null || head.next == null)
                return head;
            int length = 1;
            ListNode list = head;
            while(list.next != null) {
                length++;
                list = list.next;
            }
            k = k % length;
            if(k == 0) {
                return head;
            }
            int target = length - k;

            ListNode tail = list;

            list = head;
            int i = 1;
            while(i != target) {
                i++;
                list = list.next;
            }

            ListNode res = list.next;
            list.next = null;
            tail.next = head;

            return res;
        }

    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int diff = 0;
        ListNode p1 = head;
        ListNode p2 = head;

        while(diff < k) {
            if(p2.next == null) {
                p2 = head;
                k = k % (diff + 1);
                diff = 0;
            }
            else {
                p2 = p2.next;
                diff++;
            }
        }
        while(p2.next != null) {
            if(p1.next == null)
                p1 = head;
            else
                p1 = p1.next;

            p2 = p2.next;
        }

        if(p1 == p2) {
            return head;
        }

        ListNode res = p1.next;
        p1.next = null;
        p2.next = head;

        return res;
    }


    public static void main(String[] args) {
        Solution061 s = new Solution061();
//        ListNode list = null;
        ListNode list = new ListNode(0);
        ListNode l1 = new ListNode(1);
        list.next = l1;
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
        res = s.rotateRight1(list, 2003);
        while(res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
    }
}


/**
 * Rotate List
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */