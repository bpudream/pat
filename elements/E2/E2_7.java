package elements.E2;

import leetcode.ListNode;

import java.util.Stack;

/**
 * Created by bpudream on 15-09-10.
 */
public class E2_7 {
    public boolean isPalindrome(ListNode list) {
        if(list == null)
            return false;

        boolean res = true;
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = list;
        ListNode fast = list;
        boolean isOdd = false;

        while(fast != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next;
            if(fast == null) {
                isOdd = true;
                break;
            }
            fast = fast.next;
        }

        ListNode lastHalf = slow;
        if(isOdd) {
            stack.pop();
        }

        while(lastHalf != null) {
            ListNode p = stack.pop();
//            System.out.println(lastHalf.val + " = " + p.val);
            if(lastHalf.val != p.val) {
                res = false;
                break;
            }
            lastHalf = lastHalf.next;
        }

        return res;
    }

    public static void main(String[] args) {
        E2_7 e = new E2_7();
        int[] a = {1,2,3,2,1};
//        int[] a = {1};
//        int[] a = {1,1};
//        int[] a = {1,2,3,1,2};
//        int[] a = {1,2,3,2};
        ListNode list = ListNode.createList(a);

        System.out.println(e.isPalindrome(list));
    }
}
