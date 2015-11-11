package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by bpudream on 15-11-10.
 */
public class Solution210 {
    public int[] findOrder(int n, int[][] edges) {
        int[] res = new int[n];
        List<Integer>[] lists = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        int inDegree[] = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for(int[] e : edges) {
            lists[e[1]].add(e[0]);
            inDegree[e[0]]++;
        }
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int v = queue.remove();
            res[count++] = v;
            for(int k : lists[v]) {
                if(--inDegree[k] == 0) {
                    queue.add(k);
                }
            }
        }
        if(count != n) {
            res = new int[0];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution210 sol = new Solution210();
        int[][] edges = {{1, 0}};
        int[] res = sol.findOrder(2, edges);
        for(int v : res) {
            System.out.print(v + " ");
        }
    }
}

/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs,
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them.
 If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take.
To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */