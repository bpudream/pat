import java.util.List;

/**
 * Created by bpudream on 15-05-30.
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode list = new ListNode(-255);
        list.next = head;
        ListNode positive = new ListNode(-255);
        ListNode negative = new ListNode(-255);
        ListNode[] bucket = new ListNode[10];
        ListNode[] bucTails = new ListNode[10];

        for(int i = 0; i < 10; i++) {
            bucket[i] = new ListNode(-255);
            bucTails[i] = bucket[i];
        }

        ListNode postag = positive;
        ListNode negtag = negative;

        int min = head.val;
        int max = min;

        while(list.next != null) {
            ListNode node = list.next;
            if(node.val < 0) {
                if(node.val < min)
                    min = node.val;
                negtag.next = node;
                negtag = negtag.next;
            }
            else {
                if(node.val > max)
                    max = node.val;
                postag.next = node;
                postag = postag.next;
            }
            list.next = node.next;
            node.next = null;
        }

//        ListNode printable1 = negative;
//        while(printable1.next != null) {
//            System.out.printf("%d ", printable1.next.val);
//            printable1 = printable1.next;
//        }
//        System.out.println();

//        postag = positive;
//        negtag = negative;

        int digitPos = Integer.toString(max).length();

        if(min < 0) {
            int digitNeg = Integer.toString((-1 * min)).length();
//            System.out.println("min = " + min + " digit = " + digitNeg);
            int divisor = 1;
            for(int iter = 0; iter < digitNeg; iter++) {

                while (negative.next != null) {
                    ListNode node = negative.next;
                    int val = -1 * node.val;
                    int index = val / divisor % 10;
//                    System.out.println("val = " + val + " index = " + index);
                    bucTails[index].next = node;
                    bucTails[index] = node;
                    negative.next = node.next;
                    node.next = null;
                }

                ListNode negtail = negative;
                for (int i = 9; i >= 0; i--) {
                    ListNode temp = bucket[i];
                    while(temp.next != null) {
                        negtail.next = temp.next;
                        negtail = temp.next;
                        temp = temp.next;
                    }
                    bucket[i].next = null;
                    bucTails[i] = bucket[i];
                }

                divisor *= 10;
//                ListNode printable = negative;
//                while(printable.next != null) {
//                    System.out.printf("%d ", printable.next.val);
//                    printable = printable.next;
//                }
//                System.out.println();
            }
        }

        int divisor = 1;
        for(int iter = 0; iter < digitPos; iter++) {

            while (positive.next != null) {
                ListNode node = positive.next;
                int val = node.val;
                int index = val / divisor % 10;
//                    System.out.println("val = " + val + " index = " + index);
                bucTails[index].next = node;
                bucTails[index] = node;
                positive.next = node.next;
                node.next = null;
            }

            ListNode postail = positive;
            for (int i = 0; i < 10; i++) {
                ListNode temp = bucket[i];
                while(temp.next != null) {
                    postail.next = temp.next;
                    postail = temp.next;
                    temp = temp.next;
                }
                bucket[i].next = null;
                bucTails[i] = bucket[i];
            }

            divisor *= 10;
//            ListNode printable = positive;
//            while(printable.next != null) {
//                System.out.printf("%d ", printable.next.val);
//                printable = printable.next;
//            }
//            System.out.println();
        }

        list.next = negative.next;
        ListNode t = negative;
        while(t.next != null) {
            t = t.next;
        }
        t.next = positive.next;

//            ListNode printable = negative;
//            while(printable.next != null) {
//                System.out.printf("%d ", printable.next.val);
//                printable = printable.next;
//            }
//            System.out.println();

        return negative.next;
    }


    public static void main(String[] args) {
        Solution148 s = new Solution148();
        ListNode list = null;
//        ListNode list = new ListNode(-49);
//        ListNode l1 = new ListNode(-54);
//        list.next = l1;
//        l1.next = new ListNode(-44);
//        l1 = l1.next;
//        l1.next = new ListNode(-78);
//        l1 = l1.next;
//        l1.next = new ListNode(-28);
//        l1 = l1.next;
//        l1.next = new ListNode(-55);
//        l1 = l1.next;
//        l1.next = new ListNode(-6);
//        l1 = l1.next;
//        l1.next = new ListNode(-30);
//        l1 = l1.next;
//        l1.next = new ListNode(-93);
//        l1 = l1.next;
//        l1.next = new ListNode(-98);
//        l1 = l1.next;
//        l1.next = new ListNode(-52);
//        l1 = l1.next;
//        l1.next = new ListNode(-76);
//        l1 = l1.next;
//        l1.next = new ListNode(-32);
//        l1 = l1.next;
//        l1.next = new ListNode(-7);
//        l1 = l1.next;
//        l1.next = new ListNode(-2);
//        l1 = l1.next;
//        l1.next = new ListNode(23);
//        l1 = l1.next;
//        l1.next = new ListNode(63);
//        l1 = l1.next;
//        l1.next = new ListNode(44);
//        l1 = l1.next;
//        l1.next = new ListNode(59);
//        l1 = l1.next;
//        l1.next = new ListNode(96);
//        l1 = l1.next;
//        l1.next = new ListNode(70);
//        l1 = l1.next;

        s.sortList(list);

    }
}

// -49	-54	-44	-78	-93	-28	-52	-54	-76	-32	-95	-18	-63	-98	-24	-95	-18	-22	-64	-78
/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */