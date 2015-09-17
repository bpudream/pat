package leetcode;

/**
 * Created by bpudream on 15-09-16.
 */
public class Solution043 {
    public final static int CUT = 4;

    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();

        if(l1 * l2 == 0) {
            return "0";
        }

        char[] res = new char[l1 + l2];
        for(int i = 0; i < res.length; i++) {
            res[i] = '0';
        }

        mult(num1, num2, res, 0);

        for(int i = res.length - 1; i > 0; i--) {
            if(res[i] > '9') {
                int extra = res[i] - '9' - 1;
                int inc = extra / 10 + 1;
                res[i] = (char)('0' + extra % 10);
                res[i - 1] += inc;
            }
        }

        int i;
        for(i = 0; i < res.length; i++) {
            if(res[i] > '0') {
                break;
            }
        }

        if(i == res.length) {
            i--;
        }

        StringBuffer sb = new StringBuffer();
        while(i < res.length) {
            sb.append(res[i]);
            i++;
        }

        return sb.toString();
    }

    private void mult(String num1, String num2, char[] res, int pos) {
        int l1 = num1.length();
        int l2 = num2.length();
        if(l1 > CUT) {
            mult(num1.substring(l1 - CUT, l1), num2, res, pos);
            mult(num1.substring(0, l1 - CUT), num2, res, pos + CUT);
        }
        else if(l2 > CUT) {
            mult(num1, num2.substring(l2 - CUT, l2), res, pos);
            mult(num1, num2.substring(0, l2 - CUT), res, pos + CUT);
        }
        else {
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            int m = a * b;
            pos = res.length - 1 - pos;
            do {
                res[pos] += m % 10;
                m /= 10;
                pos--;
            } while(m != 0);
        }
    }

    public static void main(String[] args) {
        Solution043 sol = new Solution043();
        String s1 = "9999999999999999990";
        String s2 = "999999999999900000";

        System.out.println(sol.multiply(s1, s2));
    }
}

/*
* Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
* */