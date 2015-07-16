import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpudream on 15-07-16.
 */
public class Solution022 {
    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateList(0, 0, "", n);
        return list;
    }

    private void generateList(int left, int right, String s, int n) {
        if(left > n || right > n || right > left)
            return;
        if(left == n && right == n) {
            list.add(s);
        }
        else {
            generateList(left + 1, right, s + "(", n);
            generateList(left, right + 1, s + ")", n);
        }
    }

    public static void main(String[] args) {
        Solution022 sol = new Solution022();
        List<String> list = sol.generateParenthesis(3);
        for(String s : list) {
            System.out.println(s);
        }
    }
}

/**
 * Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 */