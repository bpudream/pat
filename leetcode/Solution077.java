import java.util.*;

/**
 * Created by David on 2015/6/30.
 */
public class Solution077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res  = new LinkedList<>();
        if(n < 1 || k < 1)
            return res;

        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(1);
        int counter = 1;
        int next = 2;

        while(!stack.isEmpty() || next <= n) {
            if(counter == k) {
                List<Integer> list = new ArrayList<>();
                list.addAll(stack);
                res.add(list);
                next = stack.remove(--counter) + 1;
            }
            else {
                if(next <= n)
                    stack.add(counter++, next++);
                else {
                    next = stack.remove(--counter) + 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution077 sol = new Solution077();
        List<List<Integer>> res = sol.combine(5,2);
        for(List<Integer> list : res) {
            System.out.print('[');
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.print(']');
            System.out.println();
        }
    }
}

/**
 * Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */