/**
 * Created by bpudream on 15-07-14.
 */
public class Solution012 {
    public String intToRoman(int num) {
        String res = "";

        while(num > 0) {
            int mod = 0, div = 0;
            if(num >= 1000) {
                mod = num % 1000;
                div = num / 1000;
                for(int i = 0; i < div; i++) {
                    res += 'M';
                }
            }
            else if(num >= 100) {
                mod = num % 100;
                div = num / 100;
                if(div == 9) {
                    res += "CM";
                }
                else if(div == 4) {
                    res += "CD";
                }
                else {
                    if(div > 4) {
                        res += "D";
                        div -= 5;
                    }
                    for(int i = 0; i < div; i++) {
                        res += 'C';
                    }
                }
            }
            else if(num >= 10) {
                mod = num % 10;
                div = num / 10;
                if(div == 9) {
                    res += "XC";
                }
                else if(div == 4) {
                    res += "XL";
                }
                else {
                    if(div > 4) {
                        res += "L";
                        div -= 5;
                    }
                    for(int i = 0; i < div; i++) {
                        res += 'X';
                    }
                }
            }
            else if(num > 0) {
                mod = 0;
                div = num;
                if(div == 9) {
                    res += "IX";
                }
                else if(div == 4) {
                    res += "IV";
                }
                else {
                    if(div > 4) {
                        res += "V";
                        div -= 5;
                    }
                    for(int i = 0; i < div; i++) {
                        res += 'I';
                    }
                }
            }
            num = mod;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution012 sol = new Solution012();
        System.out.println(sol.intToRoman(3555));
    }
}

/**
 * Integer to Roman
 *
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Symbol	Value
 Ⅰ	1
 Ⅴ	5
 Ⅹ	10
 Ⅼ	50
 C	100
 Ⅾ	500
 Ⅿ	1,000
 *
 */