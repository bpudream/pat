package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bpudream on 15-09-20.
 */
public class Solution078 {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        int len = (int)Math.pow(2, n);
        ArrayList<Integer> list[] = new ArrayList[len];
        Arrays.sort(a);
        for(int i = 0; i < len; i++) {
            list[i] = new ArrayList<>();
            String s = Integer.toBinaryString(i);
            int l = s.length();
            int index = n - l;
            for(int j = 0; j < l; j++) {
                if(s.charAt(j) == '1') {
                    list[i].add(a[index + j]);
                }
            }
        }

        for(ArrayList<Integer> al : list) {
            res.add(al);
        }

        return res;
    }
}

/*
Subsets

* Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
* */