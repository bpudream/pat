package leetcode;

import java.util.ArrayList;

/**
 * Created by bpudream on 15-11-09.
 */
public class Solution204 {
    public int countPrimes(int n) {
        if(n < 2) {
            return 0;
        }
        int count = 0;
        ArrayList<Integer> primes = new ArrayList<>();

        for(int val = 2; val < n; val++) {
            if(isPrime(val, primes)) {
                primes.add(val);
            }
        }

        count = primes.size();

        return count;
    }

    private boolean isPrime(int n, ArrayList<Integer> list) {
        boolean res = true;
        int root = (int)Math.sqrt(n);
        for(int p : list) {
            if(p > root) {
                break;
            }
            if(n % p == 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution204 sol = new Solution204();
        System.out.println(sol.countPrimes(1000));
    }

}
