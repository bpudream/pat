package elements.E2;

import leetcode.ListNode;

/**
 * Created by bpudream on 15-09-10.
 */
public class E2_3 {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        E2_3 e = new E2_3();
        int arr[] = {1,2,3,4,5};
        ListNode list = ListNode.createList(arr);

        e.deleteNode(list.next);

        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
