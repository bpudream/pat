package elements;

/**
 * Created by David on 2015/9/8.
 */
public class E1_1 {

    public boolean uniqueChars(String s) {
        boolean res = true;

        for(int i = 0; res && i < s.length(); i++) {
            char c = s.charAt(i);
            for(int j = i + 1; j < s.length(); j++) {
                if(c == s.charAt(j)) {
                    res = false;
                    break;
                }
            }
        }

        return res;
    }

    public boolean uniqueCharsHash(String s) {
        boolean res = true;
        final int H = 128;
        boolean table[] = new boolean[H];

        for(int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            int index = val % H;
            if(table[index]) {
                res = false;
                break;
            }
            else {
                table[index] = true;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        E1_1 e = new E1_1();
        String s = "u ni qre";
        System.out.println(e.uniqueChars(s));
        System.out.println(e.uniqueCharsHash(s));
    }
}

/*Implement an algorithm to determine if a string has all unique characters. What
if you cannot use additional data structures?
p*/