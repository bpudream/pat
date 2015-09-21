package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            build(res, i);
        }

        return res;
    }

    void build(List<List<Integer>> res, int level) {
        ArrayList<Integer> list = new ArrayList<>();
        if(level == 0) {
            list.add(1);
            res.add(list);
            return;
        }

        list.add(0, 1);
        list.add(level - 1, 1);

        ArrayList<Integer> last = (ArrayList)res.get(res.size() - 1);
        for(int i = 1; i < level - 1; i++) {
            list.add(i, last.get(i) + last.get(i - 1));
        }

        res.add(list);
    }
}

/**
 * Pascal's Triangle
 *
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */