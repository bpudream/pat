package leetcode;

/**
 * Created by bpudream on 15-09-16.
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        boolean res = true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(-255);

        while(fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast == null) {
                break;
            }
            fast = fast.next;
        }

        reverse(pre);
        fast = head;
        slow = pre.next;

        while(slow != null) {
            if(slow.val != fast.val) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }

        if(!res) {
            reverse(pre);
        }

        return res;
    }

    private void reverse(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode first = head.next;
        ListNode second = first.next;
        first.next = null;
        while(second != null) {
            head.next = second;
            second = second.next;
            head.next.next = first;
            first = head.next;
        }
    }
}

/*
* Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
* */
