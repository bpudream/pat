/**
 * Created by bpudream on 15-06-15.
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            else{
                return false;
            }
        }

        return true;
    }
}


/**
 * Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
 */