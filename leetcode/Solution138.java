package leetcode;

import java.util.HashMap;

/**
 * Created by bpudream on 15-09-16.
 */
public class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
//        if(head == null) {
//            return null;
//        }
//
        RandomListNode res = new RandomListNode(-255);
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();

//        res.next = new RandomListNode(head.label);
//        RandomListNode iter = res.next;
//        hashMap.put(head, iter);

        RandomListNode iter = res;
        RandomListNode head0 = head;

        while(head!= null) {
            RandomListNode node = new RandomListNode(head.label);
            iter.next = node;
            hashMap.put(head, node);
            iter = iter.next;
            head = head.next;
        }

        iter = res.next;
        while(head0 != null) {
            RandomListNode r = null;
            if(head0.random != null) {
                r = hashMap.get(head0.random);
            }
            iter.random = r;
            head0 = head0.next;
            iter = iter.next;
        }

        return res.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

/**
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.

 Return a deep copy of the list.
 */
