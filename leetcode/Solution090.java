package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution090 {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);

        for(int i = 0; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            build(res, a, list, 0, i);
        }

        return res;
    }

    public void build(List<List<Integer>> res, int[] a, ArrayList<Integer> list, int index, int n) {
        int size = list.size();

        if(size == n) {
            add(res, list);
            return;
        }
        int justRemoved = a[index] - 1;
        for(int i = index; i < a.length; i++) {
            if(a[i] == justRemoved) {
                continue;
            }
            list.add(size, a[i]);
            build(res, a, list, i + 1, n);
            justRemoved = list.remove(size);
        }
    }

    void add(List<List<Integer>> res, ArrayList<Integer> list) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i : list) {
            a.add(i);
        }
        res.add(a);
    }
}

/*
 * Subsets II
*
* Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
* */