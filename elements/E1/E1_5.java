package elements.E1;

/**
 * Created by bpudream on 15-09-09.
 */
public class E1_5 {
    public String compress(String s) {
        if(s == null)
            return s;

        StringBuffer res = new StringBuffer();
        char c = s.charAt(0);
        int counter = 1;

        for(int i = 1; i < s.length(); i++) {
            if(c == s.charAt(i)) {
                counter++;
            }
            else {
                res.append(c);
                if(counter > 1) {
                    res.append(counter);
                }
                c = s.charAt(i);
                counter = 1;
            }
        }

        res.append(c);
        if(counter > 1) {
            res.append(counter);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        E1_5 e = new E1_5();
        String s = "aaabbbcccdssASDEE";
        s = "abbabba";
        System.out.println(e.compress(s));
    }
}
