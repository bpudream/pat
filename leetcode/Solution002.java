/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode temp = new ListNode(0);
        res.next = temp;
        temp = res;
        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            if(val > 9) {
                carry = 1;
                val -= 10;
            }
            else {
                carry = 0;
            }
            temp.next.val = val;
            ListNode next = new ListNode(0);
            temp.next.next = next;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int val = l1.val + carry;
            if(val > 9) {
                carry = 1;
                val -= 10;
            }
            else {
                carry = 0;
            }
            temp.next.val = val;
            ListNode next = new ListNode(0);
            temp.next.next = next;
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int val = l2.val + carry;
            if(val > 9) {
                carry = 1;
                val -= 10;
            }
            else {
                carry = 0;
            }
            temp.next.val = val;
            ListNode next = new ListNode(0);
            temp.next.next = next;
            temp = temp.next;
            l2 = l2.next;
        }

        if(carry == 1) {
            temp.next.val = 1;
        }
        else {
            temp.next = null;
        }

        return res.next;
    }

    public static void main(String[] args) {
        Solution002 s = new Solution002();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        //l2.next = new ListNode(9);

        ListNode res = s.addTwoNumbers(l1, l2);
        while(res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
    }
}

/**
 * Add two numbers
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */