/**
 * Created by bpudream on 15-07-14.
 */
public class Solution008 {
    public int myAtoi(String str) {
        if(str == "" || str == null)
            return 0;
        int res = 0;
        boolean flag = false;
        boolean overflow = false;

        int i = 0;
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        if(str.charAt(0) == '+') {
            i++;
        }
        else if(str.charAt(0) == '-') {
            i++;
            flag = true;
        }
        for(i = i; i < str.length(); i ++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                int temp = res * 10 + (c - '0');
                if((temp - (c - '0')) / 10 != res || temp < 0) {
                    overflow = true;
                    break;
                }
                res = temp;
            }
            else {
                break;
            }
        }
        if(overflow) {
            if(flag)
                res = Integer.MIN_VALUE;
            else
                res = Integer.MAX_VALUE;
        }
        else if(flag)
            res = -res;
        return res;
    }

    public static void main(String args[]) {
        Solution008 sol = new Solution008();
        String s = "2147483648";
        System.out.println(sol.myAtoi(s));
    }
}
