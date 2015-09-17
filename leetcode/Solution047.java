package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bpudream on 15-09-16.
 */
public class Solution047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        boolean[] table = new boolean[nums.length];
        ArrayList<Integer> path = new ArrayList<>();

        build(nums, table, path, res);

        return res;
    }

    private void build(int[] a, boolean[] table, ArrayList<Integer> path, List<List<Integer>> res) {
        if(path.size() == a.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        int last = a[0] - 1;
        for(int i = 0; i < a.length; i++) {
            if(table[i] || a[i] == last) {
                continue;
            }
            path.add(a[i]);
            table[i] = true;
            build(a, table, path, res);
            last = path.remove(path.size() - 1);
            table[i] = false;
        }
    }
}

/*
Permutations II

* Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
* */