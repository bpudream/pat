/**
 * Created by bpudream on 15-06-01.
 */
public class Solution021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-255);
        ListNode t = res;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                t.next = l1;
                l1 = l1.next;
                t = t.next;
            }
            else {
                t.next = l2;
                l2 = l2.next;
                t = t.next;
            }
        }
        if(l1 != null)
            t.next = l1;

        if(l2 != null)
            t.next = l2;

        return res.next;
    }
}

/**
 * Merge two sorted linked lists
 */