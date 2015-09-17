package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by bpudream on 15-09-16.
 */
public class Solution046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] table = new boolean[n];

        ArrayList<Integer> list = new ArrayList<>();
        build(nums, table, list, res);

        return res;
    }

    private void build(int[] nums, boolean[] table, List<Integer> path, List<List<Integer>> res) {
        if(path.size() == nums.length) {
            ArrayList<Integer> list = new ArrayList<>(path);
            res.add(list);
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(table[i]) {
                continue;
            }
            path.add(nums[i]);
            table[i] = true;
            build(nums, table, path, res);
            path.remove(path.size() - 1);
            table[i] = false;
        }
    }
}

/*
Permutations

* Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
* */