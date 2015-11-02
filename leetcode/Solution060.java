package leetcode;

import java.util.LinkedList;

/**
 * Created by bpudream on 15-11-02.
 */
public class Solution060 {
    public String getPermutation(int n, int k) {
        StringBuffer res = new StringBuffer("");
        LinkedList<Integer> list = new LinkedList<>();
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            list.add(i);
            fact *= i;
        }
        int l = n;

        while(l > 0) {
            fact = fact / l;
            int t = (k - 1) / fact;
            int num = list.remove(t);
            res.append(num);

            l--;
            k -= fact * (t);
        }

//        res.append(list.remove(0));

        return res.toString();
    }

    public static void main(String[] args) {
        Solution060 sol = new Solution060();
        System.out.println(sol.getPermutation(3, 6));
    }
}

/*
* The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
* */
