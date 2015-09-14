package PAT;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by David on 2015/9/13.
 */
public class B1044 {
    String[] low = {"tret","jan", "feb", "mar", "apr", "may", "jun", "jly", "aug", "sep", "oct", "nov", "dec"};
    String high[] = {"", "tam", "hel", "maa", "huh", "tou", "kes", "hei", "elo", "syy", "lok", "mer", "jou"};

    HashMap<String, Integer> lowTable = new HashMap<String, Integer>();
    HashMap<String, Integer> highTable = new HashMap<String, Integer>();

    public B1044() {
        for(int i = 0; i < low.length; i++) {
            lowTable.put(low[i], i);
        }
        for(int i = 0; i < high.length; i++) {
            highTable.put(high[i], i);
        }
    }

    String toMars(int x) {
        StringBuffer res = new StringBuffer();

        if(x / 13 > 0) {
            res.append(high[x / 13]);
            if(x % 13 == 0) {
                return res.toString();
            }
            res.append(" ");
        }

        res.append(low[x % 13]);
        return res.toString();
    }

    int toEarth(String low, String high) {
        int res = 0;
        if(lowTable.containsKey(low)) {
            res += lowTable.get(low);
        }
        else {
            res += highTable.get(low) * 13;
        }
        if(high != "") {
            res += highTable.get(high) * 13;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        B1044 m = new B1044();
        int n = Integer.parseInt(in.nextLine());
        for(int i = 0; i < n; i++) {
            String s = in.nextLine();
            if(s.charAt(0) <= '9') {
                String res = m.toMars(Integer.parseInt(s));
                System.out.println(res);
            }
            else {
                int res = 0;
                String low = "", high = "";
                if(s.length() > 4) {
                    high = s.substring(0, 3);
                    low = s.substring(4);
                }
                else {
                    low = s;
                }
                res = m.toEarth(low, high);
                System.out.println(res);
            }
        }
    }
}

/*
* 火星人是以13进制计数的：

地球人的0被火星人称为tret。
地球人数字1到12的火星文分别为：jan, feb, mar, apr, may, jun, jly, aug, sep, oct, nov, dec。
火星人将进位以后的12个高位数字分别称为：tam, hel, maa, huh, tou, kes, hei, elo, syy, lok, mer, jou。
例如地球人的数字“29”翻译成火星文就是“hel mar”；而火星文“elo nov”对应地球数字“115”。为了方便交流，请你编写程序实现地球和火星数字之间的互译。

输入格式：

输入第一行给出一个正整数N（<100），随后N行，每行给出一个[0, 169)区间内的数字 —— 或者是地球文，或者是火星文。

输出格式：

对应输入的每一行，在一行中输出翻译后的另一种语言的数字。

输入样例：
4
29
5
elo nov
tam
输出样例：
hel mar
may
115
13*/