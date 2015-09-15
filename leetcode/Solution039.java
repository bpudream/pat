package leetcode;

import java.util.*;

/**
 * Created by bpudream on 15-09-15.
 */
public class Solution039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[candidates.length];
        arr[0] = candidates[0];
        map.put(arr[0], 0);
        int counter = 1;
        for(int i = 1; i < candidates.length; i++) {
            if(candidates[i] > target) {
                break;
            }
            if(candidates[i] > candidates[i - 1]) {
                arr[counter] = candidates[i];
                map.put(arr[counter], counter++);
            }
        }

        ArrayList<Integer> stack = new ArrayList<>();
        int stackIndex = 0;
        stack.add(stackIndex++, arr[0]);
        int sum = arr[0];

        if(sum == target) {
            add(stack, res);
            return res;
        }

        boolean flag = false; // remove from stack
        int nextIndex = 0; // index of next number put to stack
        while(!stack.isEmpty() || !flag) {
            if(flag) {
                int v = stack.remove(--stackIndex);
                sum -= v;
                nextIndex = map.get(v) + 1;
                flag = false;
                continue;
            }
            else {
                if(nextIndex == counter) {
                    flag = true;
                    continue;
                }
                else {
                    sum += arr[nextIndex];
                    stack.add(stackIndex++, arr[nextIndex]);
                }
            }

            if(sum == target) {
                add(stack, res);
                sum -= stack.remove(--stackIndex);
                flag = true;
            }
            else if(sum > target) {
                sum -= stack.remove(--stackIndex);
                flag = true;
            }
            else {
                flag = false;
            }
        }

        return res;
    }

    private void add(ArrayList<Integer> array, List<List<Integer>> res) {
        List<Integer> list = new ArrayList<>();
        for(int i : array) {
            list.add(i);
        }
        res.add(list);
    }
}

/*
* Given a set of candidate numbers (C) and a target number (T),
* find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
* */