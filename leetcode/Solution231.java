package leetcode;

/**
 * Created by bpudream on 15-11-25.
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        boolean res = true;
        int i = 0;
        for(; i < 32; i++) {
            if(((n >> i) & 1) == 1) {
                break;
            }
        }
        i++;
        for(;i < 32; i++) {
            if(((n >> i) & 1) == 1) {
                res = false;
                break;
            }
        }
        return res;
    }
}

/*
 * Given an integer, write a function to determine if it is a power of two.
* */