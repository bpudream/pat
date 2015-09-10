package elements.E1;

/**
 * Created by bpudream on 15-09-09.
 */
public class E1_4 {
    public String replaceSpaces(String s) {
        StringBuffer res = new StringBuffer();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                res.append("%20");
            }
            else {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        E1_4 e = new E1_4();
        String s = "hello wolrd, this is stupid.";
        System.out.println(e.replaceSpaces(s));
    }
}
