/**
 * Created by bpudream on 15-06-17.
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode res = new ListNode(-255);
        res.next = head;
        ListNode iter = head.next;
        head.next = null;
        while(iter != null) {
            ListNode t = res;
            while(t.next != null && iter.val > t.next.val)
                t = t.next;
            ListNode node = iter;
            iter = iter.next;
            node.next = t.next;
            t.next = node;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution147 sol = new Solution147();
        int arr[] = {2,1};
//        int arr[] = {1,2,3,4,5,6,7,8};
        ListNode list = ListNode.createList(arr);
//        list = null;

        list = sol.insertionSortList(list);
        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}

/**
 * Insertion Sort List
 *
 * Sort a linked list using insertion sort.
 */