package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by bpudream on 15-09-15.
 */
public class Solution040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        if(n == 0) {
            return res;
        }

        Arrays.sort(candidates);

        ArrayList<Integer> stack = new ArrayList<>();
        int stackIndex = 0;
        boolean flag = false;
        int sum = 0;
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);

        int nextIndex = 0;
        int justPoped = -1;

        while(!stack.isEmpty() || !flag) {
            if(flag) {
                justPoped = stack.remove(--stackIndex);
                sum -= justPoped;
                nextIndex = indexStack.pop() + 1;
                flag = false;
                continue;
            }
            else {
                if(nextIndex == n) {
                    flag = true;
                    continue;
                }
                if(candidates[nextIndex] == justPoped) {
                    nextIndex++;
                    continue;
                }
                indexStack.push(nextIndex);
                stack.add(stackIndex++, candidates[nextIndex]);
                sum += candidates[nextIndex];
            }

            if(sum < target) {
                flag = false;
                nextIndex = indexStack.peek() + 1;
            }
            else if(sum == target) {
                add(stack, res);
                sum -= stack.remove(--stackIndex);
                indexStack.pop();
                flag = true;
            }
            else {
                sum -= stack.remove(--stackIndex);
                indexStack.pop();
                flag = true;
            }
        }

        return res;
    }

    private void add(ArrayList<Integer> list, List<List<Integer>> res) {
        List<Integer> l = new ArrayList<>();
        for(int i : list) {
            l.add(i);
        }
        res.add(l);
    }

    public static void main(String[] args) {
        Solution040 sol = new Solution040();
        int a[] = {10,1,2,7,6,1,5};
        List<List<Integer>> list = sol.combinationSum2(a, 8);
        for(List<Integer> l : list) {
            for(int i : l) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
}

/*
Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
* */