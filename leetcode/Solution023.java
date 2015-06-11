/**
 * Created by bpudream on 15-06-11.
 */
public class Solution023 {
    private ListNode merge(ListNode a, ListNode b) {
        ListNode res = new ListNode(-255);
        ListNode tail = res;
        while(a != null && b != null) {
            if(a.val < b.val) {
                tail.next = a;
                a = a.next;
            }
            else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a != null)
            tail.next = a;
        if(b != null)
            tail.next = b;

        return res.next;
    }

    private ListNode[] mergeLists(ListNode[] lists) {
        int n = lists.length;
        int m = (n + 1) / 2;
        ListNode[] res = new ListNode[m];

        for(int i = 0; i < m; i++) {
            if(i + m < n)
                res[i] = merge(lists[i], lists[i + m]);
            else
                res[i] = lists[i]; // was missing
        }

        return res;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) // was missing
            return null;

        ListNode[] res = lists;
        while(res.length > 1) {
            res = mergeLists(res);
        }

        return res[0];
    }

    public static void main(String[] args) {
        Solution023 sol = new Solution023();
        ListNode[] lists = new ListNode[3];
        lists[0] = null;
        int[] a1 = {1, 5, 10};
        lists[1] = ListNode.createList(a1);
        int[] a2 = {3, 9};
        lists[2] = ListNode.createList(a2);



//        lists[1] = null;
//        lists[0] = null;
//        lists = new ListNode[0];

        ListNode res = sol.mergeKLists(lists);
        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

}

/**
 * Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */