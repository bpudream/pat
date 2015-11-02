package leetcode;

/**
 * Created by bpudream on 15-11-02.
 */
public class Solution070 {
    public int climbStairs1(int n) {
        int res = 0;
        int hash[] = new int[n + 2];
        hash[1] = 1;
        hash[2] = 2;
        res = helper(n, hash);
        return res;
    }

    private int helper(int n, int[] hash) {
        if(n <= 0) {
            return 0;
        }
        if(hash[n] > 0) {
            return hash[n];
        }
        return (hash[n] = helper(n - 1, hash) + helper(n - 2, hash));
    }

    public int climbStairs(int n) {
        int fib[] = new int[n + 2];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}

/*
* You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
* */