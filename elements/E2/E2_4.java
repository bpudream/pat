package elements.E2;

import leetcode.ListNode;

/**
 * Created by bpudream on 15-09-10.
 */
public class E2_4 {
    public void partition(ListNode list, int v) {
        if(list == null) {
            return;
        }

        ListNode firstIter = list;
        ListNode secondHead = new ListNode(0);
        ListNode secondIter = secondHead;

        if(list.val > v) {
            secondHead.next = new ListNode(list.val);
            secondIter = secondHead.next;
        }

        while(firstIter.next != null) {
            if(firstIter.next.val > v) {
                secondIter.next = firstIter.next;
                secondIter = secondIter.next;
                firstIter.next = firstIter.next.next;
            }
            else {
                firstIter = firstIter.next;
            }
        }

        secondIter.next = null;
        firstIter.next = secondHead.next;

        if(list.val > v) {
            list.val = list.next.val;
            list.next = list.next.next;
        }
    }

    public static void main(String[] args) {
        E2_4 e = new E2_4();
        int a1[] = {5,4,3,2,1};
        int a2[] = {1};
        ListNode l1 = ListNode.createList(a1);
        ListNode l2 = ListNode.createList(a2);

//        e.partition(l1, 3);
//        e.partition(l1, 6);
        e.partition(l1, 0);
        ListNode.printList(l1);

//        e.partition(l2, 0);
        e.partition(l2, 2);
        ListNode.printList(l2);
    }
}
