/**
 * Created by bpudream on 15-06-11.
 */
public class Solution083 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode tail = head;
        while(tail.next != null) {
            if(tail.val == tail.next.val)
                tail.next = tail.next.next;
            else
                tail = tail.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution083 sol = new Solution083();
        int arr[] = {1,1,1,2,2,3,4,5,5,6};
        ListNode list = ListNode.createList(arr);
//        list = null;
        list = new ListNode(0);
        list = sol.deleteDuplicates(list);
        while(list != null) {
            System.out.println(list.val + " ");
            list = list.next;
        }
    }
}

/**
 * Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */