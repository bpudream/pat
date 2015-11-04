package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bpudream on 15-11-04.
 */
public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        if(n == 0) {
            return res;
        }
        HashMap<String, List<List<String>>> table = new HashMap<>();
        HashMap<String, Boolean> check = new HashMap<>();
        table.put("", new ArrayList<List<String>>());
        check.put("", false);

        build(s, table, check);

        return table.get(s);
    }

    private void build(String s, HashMap<String, List<List<String>>> table, HashMap<String, Boolean> check) {
        for(int i = s.length() - 1; i >=0; i--) {
            String sub = s.substring(i);
            List<List<String>> newlist = new ArrayList<>();
            for(int j = 1; j <= sub.length(); j++) {
                String left = sub.substring(0, j);
                String right = sub.substring(j);
                boolean leftIsP = false;
                if(check.containsKey(left)) {
                    leftIsP = check.get(left);
                }
                else {
                    leftIsP = isP(left);
                    check.put(left, leftIsP);
                }
                if(leftIsP) {
                    List<List<String>> rightlist = table.get(right);
                    if(rightlist.size() < 1) {
                        List<String> nl = new ArrayList<>();
                        nl.add(left);
                        newlist.add(nl);
                    }
                    else {
                        for (List<String> l : rightlist) {
                            List<String> nl = new ArrayList<>();
                            nl.add(left);
                            nl.addAll(l);
                            newlist.add(nl);
                        }
                    }
                }
            }
            table.put(sub, newlist);
        }
    }

    private boolean isP(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution131 sol = new Solution131();
        String s = "aabab";
        List<List<String>> res = sol.partition(s);
        for(List<String> list : res) {
            System.out.print("[");
            for(String str : list) {
                System.out.print(str + ", ");
            }
            System.out.println("]");
        }
    }
}


/*
* Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
* */