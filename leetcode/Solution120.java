package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> t) {
        int sum = 0;
        int row = t.size();
        if(row == 0) {
            return sum;
        }
        List<Integer> last = t.get(0);
        sum = last.get(0);
        if(row == 1) {
            return sum;
        }

        for(int i = 1; i < row; i++) {
            List<Integer> current = t.get(i);
            current.set(0, current.get(0) + last.get(0));
            int j;
            for(j = 1; j < i; j++) {
                current.set(j, current.get(j) + min(last.get(j - 1), last.get(j)));
            }
            current.set(j, current.get(j) + last.get(j - 1));
            last = current;
        }

        sum = last.get(0);
        for(int i = 1; i < last.size(); i++) {
            if(last.get(i) < sum) {
                sum = last.get(i);
            }
        }

        return sum;
    }

    int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        Solution120 sol = new Solution120();
        List<List<Integer>> list = new ArrayList<>();
        int[][] a = {{2}, {3,4}, {6,5,7}, {4,1,8,3}};
        sol.add(list, a);
        sol.minimumTotal(list);
    }

    void add(List<List<Integer>> list, int[][] a) {
        for(int[] arr : a) {
            ArrayList<Integer> al = new ArrayList<>();
            for(int i : arr) {
                al.add(i);
            }
            list.add(al);
        }
    }
}

/**
 * Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space,
 where n is the total number of rows in the triangle.
 * */