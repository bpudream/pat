package leetcode;

/**
 * Created by bpudream on 15-11-02.
 */
public class Solution067 {
    public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer("");
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int flag = 0;
        while(ai >= 0 && bi >= 0) {
            int sum = (a.charAt(ai--) - '0') + (b.charAt(bi--) - '0') + flag;
            if(sum > 1) {
                sum -= 2;
                flag = 1;
            }
            else {
                flag = 0;
            }
            res.insert(0, sum);
        }
        while(ai >= 0) {
            if(flag == 0) {
                res.insert(0, a.substring(0, ai + 1));
                break;
            }
            int sum = (a.charAt(ai--) - '0') + flag;
            if(sum > 1) {
                sum -= 2;
                flag = 1;
            }
            else {
                flag = 0;
            }
            res.insert(0, sum);
        }
        while(bi >= 0) {
            if(flag == 0) {
                res.insert(0, b.substring(0, bi + 1));
                break;
            }
            int sum = (b.charAt(bi--) - '0') + flag;
            if(sum > 1) {
                sum -= 2;
                flag = 1;
            }
            else {
                flag = 0;
            }
            res.insert(0, sum);
        }

        if(flag == 1) {
            res.insert(0, flag);
        }

        int i = 0;
        for(i = 0; i < res.length(); i++) {
            if(res.charAt(i) != '0') {
                break;
            }
        }
        if(i > 0) {
            res.delete(0, i);
        }

        if(res.length() == 0) {
            return "0";
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution067 sol = new Solution067();
        String a = "01" , b = "00011";
        System.out.println(sol.addBinary(a, b));
    }
}
