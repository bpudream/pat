import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2015/11/17.
 */
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        build(k, n, 1, list, res);
        return res;
    }

    private void build(int k, int n, int start, List<Integer> list, List<List<Integer>> res) {
        if(n < 0 || k < 0) {
            return;
        }
        if(k == 0) {
            if(n == 0) {
                List<Integer> newlist = new ArrayList<>(list);
                res.add(newlist);
            }
            return;
        }
        for(int i = start; i < 10; i++) {
            list.add(i);
            build(k - 1, n - i, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution216 sol = new Solution216();
        System.out.println(sol.combinationSum3(3, 9));
    }
}

/*
* Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


* */