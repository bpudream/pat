package leetcode;

/**
 * Created by bpudream on 15-11-02.
 */
public class Solution069 {
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        long a = 1, b = x;
        long res = 1;

        while(true) {
            res = (a + b) / 2;
            if(res * res <= x && (res + 1) * (res + 1) >= x) {
                break;
            }
            if(res * res < x) {
                a = res;
            }
            else {
                b = res;
            }
        }

        return (int)res;
    }

    public int mySqrt1(int x) {
        if(x <= 0) {
            return 0;
        }
        int a = 1, b = x;
        int res = 1;
        if(b > 46341) {
            b = 46341;
        }

        while(true) {
            res = (a + b) / 2;
            if(res * res < x && (res + 1) * (res + 1) > x || res * res == x) {
                break;
            }
            if(res == a) {
                break;
            }
            if(res * res < x) {
                a = res;
            }
            else {
                b = res;
            }
        }

        return res;
    }

    public static void main(String args[]) {
        int max = Integer.MAX_VALUE;
        long maxl = Integer.MAX_VALUE;
        maxl++;
        System.out.println(Math.sqrt(maxl));
        Solution069 sol = new Solution069();
        System.out.println(sol.mySqrt1(max) + " : " + Math.sqrt(max));
    }
}

/*
* Implement int sqrt(int x).

Compute and return the square root of x.
* */