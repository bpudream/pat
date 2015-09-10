package elements.E2;

import leetcode.ListNode;

/**
 * Created by bpudream on 15-09-10.
 */
public class E2_5 {
    public ListNode listAdd(ListNode a, ListNode b) {
        ListNode res = new ListNode(0);
        ListNode iter = res;
        boolean flag = false;
        int x = 0;

        while(a != null && b != null) {
            x = flag ? 1 : 0;
            int sum = a.val + b.val + x;
            if(sum > 9) {
                flag = true;
                sum -= 10;
            }
            else {
                flag = false;
            }
            ListNode node = new ListNode(sum);
            iter.next = node;
            iter = iter.next;
            a = a.next;
            b = b.next;
        }

        ListNode remains = (b == null) ? a : b;

        if(!flag) {
            iter.next = remains;
        }
        else {
            while(remains != null && flag) {
                int sum = remains.val + 1;
                if(sum > 9) {
                    flag = true;
                    sum -= 10;
                }
                else {
                    flag = false;
                }
                ListNode node = new ListNode(sum);
                iter.next = node;
                iter = iter.next;
                remains = remains.next;
            }

            if(flag) {
                iter.next = new ListNode(1);
            }
            else {
                iter.next = remains;
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
        E2_5 e = new E2_5();
        int[] a = {1,1, 1};
        int[] b = {9,9,9};

        ListNode l1 = ListNode.createList(a);
        ListNode l2 = ListNode.createList(b);

        ListNode.printList(e.listAdd(l1, l2));
    }
}
