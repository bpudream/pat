/**
 * Created by bpudream on 15-06-17.
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode res = null;
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            else {
                return null;
            }
        }

        while(slow.next != head) {
            head = head.next;
            slow = slow.next;
        }

        res = head;
        return res;
    }
}

/**
 * Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */