/**
 * Created by bpudream on 15-06-15.
 */
public class Solution206 {
    private ListNode reverseListLocal(ListNode list, ListNode res) {
        if(list != null) {
            ListNode node = list;
            list = list.next;
            node.next = res;
            res = node;
            res = reverseListLocal(list, res);
        }

        return res;
    }

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        res = reverseListLocal(head, res);
        return res;
    }


    public static void main(String[] args) {
        Solution206 sol = new Solution206();
//        int arr[] = {1};
        int arr[] = {1,2,3,4,5,6};
        ListNode list = ListNode.createList(arr);
//        list = null;

        list = sol.reverseList(list);
        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
