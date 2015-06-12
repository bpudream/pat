/**
 * Created by bpudream on 15-06-11.
 */
public class Solution086 {
    public ListNode partition(ListNode head, int x) {
//        ListNode res = new ListNode(0);
        ListNode less = new ListNode(0);
        ListNode ltail = less;
        ListNode greater = new ListNode(0);
        ListNode gtail = greater;
//        boolean flag = false;
        while(head != null) {
            if(head.val < x) {
                ltail.next = head;
                ltail = head;
            }
            else {
//                if(head.val == x)
//                    flag = true;
                gtail.next = head;
                gtail = head;
            }
            head = head.next;
        }

//        if(!flag) {
            ltail.next = greater.next;
//        }
        gtail.next = null;

        return less.next;
    }

    public static void main(String[] args) {
        Solution086 sol = new Solution086();
        int arr[] = {1,1,1,2,2,3,4,5,5,6};
//        int arr[] = {1,1,1,2,2};
        ListNode list = ListNode.createList(arr);
//        list = null;
//        list = new ListNode(0);
        list = sol.partition(list, 4);
        while(list != null) {
            System.out.println(list.val + " ");
            list = list.next;
        }
    }
}


/**
 * Partition List
 *
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */