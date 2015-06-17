import java.util.Stack;

/**
 * Created by bpudream on 15-06-17.
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        Stack<ListNode> sa = new Stack<>();
        Stack<ListNode> sb = new Stack<>();

        while(headA != null) {
            sa.push(headA);
            headA = headA.next;
        }
        while(headB != null) {
            sb.push(headB);
            headB = headB.next;
        }

        ListNode node;
        while(!sa.empty() && !sb.empty()) {
            node = sa.pop();
            if(node.val == sb.pop().val)
                res =  node;
            else
                break;
        }

        return res;
    }
}


/**
 * Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */