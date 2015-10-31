package leetcode;

/**
 * Created by bpudream on 15-10-31.
 */

import java.util.HashMap;

public class Solution050 {
    public double myPow(double x, int n) {
        double res = 1;
        if(x == 1 || n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        if(x < 0) {
            res = myPow(-x, n);
            if(n % 2 == 1) {
                res = -res;
            }
            return res;
        }
        if(n < 0) {
            res = 1.0 / myPow(x, -n);
            return res;
        }

         if(x < 1 && n > 1000000) {
             res = pow(x, n, 1);
             return res;
         }

         for(int i = 0; i < n; i++) {
             res *= x;
         }

//        if(n < 100) {
//            res = 1;
//            for(int i = 0; i < n; i++) {
//                res *= x;
//            }
//            return res;
//        }
//
//        double hash[] = new double[64];
//        int index = 1;
//        hash[index] = x;
//
//        int t = 1;
//        res = x;
//
//        while(t * 2 <= n && t * 2 > t) {
//            res = res * res;
//            t *= 2;
//            System.out.println(index + 1);
//            hash[++index] = res;
//        }
//
//        int diff = n - t;
//        while(diff > 10) {
//            t /= 2;
//            res += hash[--index];
//            diff -= t;
//        }
//
//        res = res * myPow(x, diff);

        return res;
    }

     private double pow(double x, int n, double res) {
         if(n == 0) {
             return res;
         }
         if(res == 0) {
             return 0;
         }

         return pow(x, n - 1, res * x);
     }

    public static void main(String[] args) {
        Solution050 sol = new Solution050();
        System.out.println(sol.myPow(1.00001, 123456));
    }
}


/*
* Implement pow(x, n).
* */