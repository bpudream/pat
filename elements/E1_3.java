package elements;

/**
 * Created by David on 2015/9/8.
 */
public class E1_3 {
    public boolean isPermutation(String s1, String s2) {
        boolean res = true;
        int length = s1.length();
        if(length != s2.length()) {
            res = false;
        }
        else {
            for(int i = 0; i < length; i++) {
                if(s1.charAt(i) != s2.charAt(length - 1 - i)) {
                    res = false;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        E1_3 e = new E1_3();
        String s1 = "cat";
        String s2 = "tac";
        System.out.println(e.isPermutation(s1, s2));
    }
}


/*Given two strings, write a method to decide if one is a permutation of the other.*/