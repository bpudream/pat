package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by bpudream on 15-11-03.
 */
public class Solution093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if(n < 4 || n > 12) {
            return res;
        }
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        build(s, 0, set, list);
        for(String str : set) {
            res.add(str);
        }
        return res;
    }

    private void build(String s, int index, HashSet<String> res, ArrayList<String> list) {
        if(index == s.length() && list.size() == 4) {
            StringBuffer sb = new StringBuffer("");
            sb.append(list.get(0));
            sb.append('.');
            sb.append(list.get(1));
            sb.append('.');
            sb.append(list.get(2));
            sb.append('.');
            sb.append(list.get(3));
            if(!res.contains(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }
        else if(list.size() == 4) {
            // list = new ArrayList<>();
            return;
        }
        else if(index >= s.length()) {
            // list = new ArrayList<>();
            return;
        }
        else {
            list.add(s.substring(index, index + 1));
            build(s, index + 1, res, list);
            list.remove(list.size() - 1);

            if(index + 1 < s.length()) {
                if(s.charAt(index) != '0') {
                    list.add(s.substring(index, index + 2));
                    build(s, index + 2, res, list);
                    list.remove(list.size() - 1);
                }
            }

            if(index + 2 < s.length()) {
                if(s.charAt(index) != '0') {
                    int val = (s.charAt(index) - '0') * 100 + (s.charAt(index + 1) - '0') * 10 + (s.charAt(index + 2) - '0');
                    if (val < 256) {
                        list.add(s.substring(index, index + 3));
                        build(s, index + 3, res, list);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution093 sol = new Solution093();
        String s = "010010";
        List<String> res = sol.restoreIpAddresses(s);
        for(String e : res)
            System.out.println(e);
    }
}

/*
* Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
* */