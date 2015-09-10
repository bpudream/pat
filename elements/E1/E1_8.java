package elements.E1;

/**
 * Created by bpudream on 15-09-09.
 */
public class E1_8 {
    public boolean isRotation(String a, String b) {
        int length = a.length();

        if(length != b.length()) {
            return false;
        }

        if(length == 0) {
            return true;
        }

        boolean res = false;
        int i;

        for(i = 0; i < length; i++) {
            String suba = a.substring(i);
            String subb = b.substring(0, length - i);
//            System.out.println(suba + " : " + subb);
            if(suba.hashCode() == subb.hashCode()) {
                break;
            }
        }
//System.out.println("i = " + i);
        if(i < length) {
            String newa = a.substring(i).concat(a.substring(0, i));
//System.out.println(newa);
            if(isSubstring(newa, b)) {
                res = true;
            }
        }

        return res;
    }

    private boolean isSubstring(String sub, String str) {
        return str.contains(sub);
    }

    public static void main(String[] args) {
        E1_8 e = new E1_8();
        String a = "abcabc";
        String b = "cabcbc";
        System.out.println(e.isRotation(a,b));
    }
}
