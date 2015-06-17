/**
 * Created by bpudream on 15-06-17.
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode list = new ListNode(-255);
        list.next = head;
        ListNode iter = list;
        while(iter.next != null) {
            if(iter.next.val == val) {
                iter.next = iter.next.next;
            }
            else
                iter = iter.next;
        }

        return list.next;
    }
}

/**
 * Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
