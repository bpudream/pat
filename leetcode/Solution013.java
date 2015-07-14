/**
 * Created by bpudream on 15-07-14.
 */
public class Solution013 {
    private int r2i(char c) {
        int res = 0;

        switch(c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
        }

        return res;
    }

    public int romanToInt(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = r2i(c);
            if(i + 1 != s.length()) {
                char nx = s.charAt(i + 1);
                if(digit < r2i(nx))
                    digit = -digit;
            }
            res += digit;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution013 sol = new Solution013();
        System.out.println(sol.romanToInt("XV"));
    }
}

/**
 * Roman to Integer
 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Ⅰ	1
 Ⅴ	5
 Ⅹ	10
 Ⅼ	50
 C	100
 Ⅾ	500
 Ⅿ	1,000
 */