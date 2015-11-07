/**
 * Created by David on 2015/11/7.
 */
public class Solution168 {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer("");
        while(n > 0) {
            int mod = (n - 1) % 26;
            char c = (char)('A' + mod);
            sb.insert(0, c);
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
}

/*
* Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
* */
