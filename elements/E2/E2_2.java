package elements.E2;

import leetcode.ListNode;

/**
 * Created by bpudream on 15-09-09.
 */
public class E2_2 {
    public ListNode findKthLast(ListNode list, int k) {
        ListNode res = null;
        ListNode iter = list;

        int i;
        for(i = 0; i < k; i++) {
            if(iter != null) {
                iter = iter.next;
            }
            else {
                break;
            }
        }

        if(i == k) {
            res = list;
        }

        while(iter != null) {
            iter = iter.next;
            res = res.next;
        }

        return res;
    }

    public static void main(String[] args) {
        E2_2 e = new E2_2();
        int arr[] = {1,2,3,4,5,6};
//        arr = new int[0];
        ListNode list = ListNode.createList(arr);

        ListNode res = e.findKthLast(list, 6);
        if(res != null)
            System.out.println(res.val);
        else {
            System.out.println("null");
        }

    }
}
