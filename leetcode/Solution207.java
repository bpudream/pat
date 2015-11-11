package leetcode;

import java.util.*;

/**
 * Created by bpudream on 15-11-09.
 */
public class Solution207 {
    public boolean canFinish(int n, int[][] edges) {
        boolean res = true;

        List<Integer>[] lists = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        // build adjacency lists
        for(int[] edge : edges) {
            lists[edge[1]].add(edge[0]);
        }

        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int val : lists[i]) {
                inDegree[val]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        int count = 0;
        for(int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int v = queue.remove();
            count++;
            for(int k : lists[v]) {
                if(--inDegree[k] == 0) {
                    queue.add(k);
                }
            }
        }

        if(count != n) {
            res = false;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution207 sol = new Solution207();
        int[][] edges = {{1, 0}};
        System.out.println(sol.canFinish(2, edges));
    }
}

/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0,
and to take course 0 you should also have finished course 1. So it is impossible.
 */