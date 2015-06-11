/**
 * Created by bpudream on 15-06-11.
 */
public class Solution082 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode list = new ListNode(-255);
        list.next = head;
        ListNode tail = list.next;
        ListNode pre = list;

        boolean flag = false;

        while(tail.next != null) {
            if(tail.next.val != tail.val) {
                if(flag) {
                    flag = false;
                    pre.next = tail.next;
                }
                else {
                    pre = tail;
                }
                tail = tail.next;
            }
            else {
                flag = true;
                tail.next = tail.next.next;
            }
        }

        if(flag) {
            pre.next = null;
        }

        return list.next;
    }

    public static void main(String[] args) {
        Solution082 sol = new Solution082();
//        int arr[] = {1,1,1,2,2,3,4,5,5,6};
        int arr[] = {1,1,1,2,2};
        ListNode list = ListNode.createList(arr);
        list = null;
//        list = new ListNode(0);
        list = sol.deleteDuplicates(list);
        while(list != null) {
            System.out.println(list.val + " ");
            list = list.next;
        }
    }
}


/**
 * Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */