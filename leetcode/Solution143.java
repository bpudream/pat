/**
 * Created by bpudream on 15-06-15.
 */
public class Solution143 {

    private ListNode reverse(ListNode list) {
        ListNode res = new ListNode(0);
        while(list != null) {
            ListNode t = list;
            list = list.next;
            t.next = res.next;
            res.next = t;
        }
        return res.next;
    }

    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode iter = head;
        ListNode halfIter = new ListNode(-1);
        halfIter.next = head;
        boolean flag = false;
        while(iter != null) {
            iter = iter.next;
            if(flag)
                halfIter = halfIter.next;
            flag = !flag;
        }

        if(flag)
            halfIter = halfIter.next;

        ListNode second = halfIter.next;
        halfIter.next = null;
        ListNode first = head.next;
        second = reverse(second);

        ListNode tail = head;

        while(first != null) {
            ListNode n1 = first;
            ListNode n2 = second;
            first = first.next;
            second = second.next;
            n2.next = n1;
            n1.next = null;
            tail.next = n2;
            tail = n1;
        }

        tail.next = second;
        if(second != null)
            second.next = null;
    }

    public static void main(String[] args) {
        Solution143 sol = new Solution143();
        int arr[] = {1,2,3};
//        int arr[] = {1,2,3,4,5,6,7,8};
        ListNode list = ListNode.createList(arr);
//        list = null;

        sol.reorderList(list);
        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}

/**
 * Reorder List
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */