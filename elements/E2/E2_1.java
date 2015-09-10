package elements.E2;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bpudream on 15-09-09.
 */
public class E2_1 {
    public void removeDuplicates(ListNode list) {
        ListNode head = list;

        while(head != null) {
            ListNode iter = head;
            while(iter.next != null) {
                if(iter.next.val == head.val) {
                    iter.next = iter.next.next;
                }
                else {
                    iter = iter.next;
                }
            }
            head = head.next;
        }
    }

    public void removeDuplicatesFast(ListNode list) {
        ListNode head = new ListNode(0);
        head.next = list;
        Set<Integer> set = new HashSet<>();
        while(head.next != null) {
            if(set.contains(head.next.val)) {
                head.next = head.next.next;
            }
            else {
                set.add(head.next.val);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        E2_1 e = new E2_1();
        int arr[] = {1,2,3,4,1,2,3,2,1,1,2,4,5,6,2,3,1};
//        arr = new int[0];
        ListNode list = ListNode.createList(arr);

        e.removeDuplicatesFast(list);

        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
