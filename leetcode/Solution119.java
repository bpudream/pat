package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution119 {
    public List<Integer> getRow(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        a[0] = 1;
        b[0] = 1;
        int length = 1;
        boolean flag = true;
        int[] source, target = b;

        while(target[n] == 0) {
            if(flag) {
                source = a;
                target = b;
            }
            else {
                source = b;
                target = a;
            }

            for(int i = 1; i <= length; i++) {
                target[i] = source[i] + source[i - 1];
            }

            length++;
            flag = !flag;
        }

        for(int i : target) {
            list.add(i);
        }

        return list;
    }
}

/*
* Pascal's Triangle
*
* Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
* */