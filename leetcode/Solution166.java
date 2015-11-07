import java.util.HashMap;

/**
 * Created by David on 2015/11/7.
 */
public class Solution166 {
    public String fractionToDecimal(int aa, int bb) {
        StringBuffer res = new StringBuffer("");

        long a = aa;
        long b = bb;

        if(b == 0) {
            return "";
        }

        if(a == 0) {
            return "0";
        }

        boolean isNegtive = false;
        if(a*b < 0) {
             a = Math.abs(a);
             b = Math.abs(b);
            isNegtive = true;
        }
         else if(a < 0) {
             a = -a;
             b = -b;
         }

        HashMap<Long, Integer> hash = new HashMap<>();
        int pos = 0;
        boolean hasPoint = false;

        while(a != 0) {
            if(hash.containsKey(a)) {
                pos = hash.get(a);
                break;
            }
            else {
                hash.put(a, pos);
            }
            if(a < b) {
                if(pos == 0) {
                    res.append("0.");
                    hasPoint = true;
                    pos += 2;
                }
                else {
                    res.append(0);
                    pos++;
                }
                a *= 10;
            }
            else {
                long val = a / b;
                res.append(val);
                a = a % b * 10;
                pos += ("" + val).length();
                if(!hasPoint && a != 0) {
                    res.append('.');
                    hasPoint = true;
                    pos++;
                }
            }
        }

        if(a != 0) {
            res.insert(pos, '(');
            res.append(')');
        }

        if(isNegtive) {
            res.insert(0, '-');
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution166 sol = new Solution166();
        System.out.println(sol.fractionToDecimal(76,354));

    }
}
