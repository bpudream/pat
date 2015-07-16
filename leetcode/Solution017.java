import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bpudream on 15-07-14.
 */
public class Solution017 {

    char[][] dialpad = {{}, {}, {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)
            return res;
        ArrayList<Character> stack = new ArrayList<>();
        int counter = 0;
        int length = digits.length();
        int[] indextable = new int[length];
        for(int i = 0; i < length; i++) {
            int index = digits.charAt(i) - '0';
            stack.add(counter++, dialpad[index][0]);
            indextable[i]++;
        }
        while(!stack.isEmpty() || indextable[0] < dialpad[digits.charAt(0) - '0'].length) {
            if(counter == length) {
                String s = "";
                for(char c : stack) {
                    s += c;
                }
                res.add(s);

                char c = stack.remove(--counter);
            }
            else {
                int num = digits.charAt(counter) - '0';
                if(indextable[counter] < dialpad[num].length) {
                    stack.add(counter, dialpad[num][indextable[counter]++]);
                    counter++;
                }
                else {
                    indextable[counter--] = 0;
                    stack.remove(counter);
                }
            }
        }
        return res;
    }

//    private boolean contains(int number, char c) {
//        char[] charset = dialpad[number];
//        return c <= charset[charset.length - 1] ? true : false;
//    }

    public static void main(String[] args) {
        Solution017 sol = new Solution017();
        String s = "";
        List<String> list = sol.letterCombinations(s);
        for(String str : list) {
            System.out.println(str);
        }
    }
}

/**
 * Letter Combinations of a Phone Number
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.


 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */