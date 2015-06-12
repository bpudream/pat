/**
 * Created by bpudream on 15-06-11.
 */
public class Solution092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        int i = 1;
        ListNode res = new ListNode(0);
        ListNode rtail = res;
        ListNode list = new ListNode(0);
        ListNode reverse = new ListNode(0);
        list.next = head;

        while(list.next != null) {
            if(i == m)
                break;
            rtail.next = list.next;
            rtail = rtail.next;
            list.next = list.next.next;
            i++;
        }

        ListNode temp = list.next;

        while(i <= n) {
            ListNode t = list.next;
            list.next = t.next;
            t.next = reverse.next;
            reverse.next = t;
            i++;
        }

        rtail.next = reverse.next;
        temp.next = list.next;

        return res.next;
    }

    public static void main(String[] args) {
        Solution092 sol = new Solution092();
//        int arr[] = {1};
        int arr[] = {1,2,3,4,5,6};
        ListNode list = ListNode.createList(arr);
//        list = null;

        list = sol.reverseBetween(list, 1,6);
        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}


/**
 * Reverse Linked List II
 *
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 */