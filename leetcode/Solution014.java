/**
 * Created by bpudream on 15-07-14.
 */
public class Solution014 {
    private void merge(String[] strs, int len) {
        for(int i = 0; i < len / 2; i++) {
            String s1 = strs[i];
            String s2 = strs[len - 1 - i];
            int iter = 0;
            while(iter < s1.length() && iter < s2.length()) {
                if(s1.charAt(iter) == s2.charAt(iter))
                    iter++;
                else
                    break;;
            }
            strs[i] = s1.substring(0, iter);
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int len = strs.length;
        while(len > 1) {
            merge(strs, len);
            len = (len + 1) / 2;
        }
        return strs[0];
    }
}

/**
 * Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 */