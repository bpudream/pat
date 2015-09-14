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
* ����������13���Ƽ����ģ�

�����˵�0�������˳�Ϊtret��
����������1��12�Ļ����ķֱ�Ϊ��jan, feb, mar, apr, may, jun, jly, aug, sep, oct, nov, dec��
�����˽���λ�Ժ��12����λ���ֱַ��Ϊ��tam, hel, maa, huh, tou, kes, hei, elo, syy, lok, mer, jou��
��������˵����֡�29������ɻ����ľ��ǡ�hel mar�����������ġ�elo nov����Ӧ�������֡�115����Ϊ�˷��㽻���������д����ʵ�ֵ���ͻ�������֮��Ļ��롣

�����ʽ��

�����һ�и���һ��������N��<100�������N�У�ÿ�и���һ��[0, 169)�����ڵ����� ���� �����ǵ����ģ������ǻ����ġ�

�����ʽ��

��Ӧ�����ÿһ�У���һ���������������һ�����Ե����֡�

����������
4
29
5
elo nov
tam
���������
hel mar
may
115
13*/