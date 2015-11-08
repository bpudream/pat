package leetcode;

/**
 * Created by bpudream on 15-11-08.
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int counter = 0;
        for(int i = 0; i < 32; i++) {
            counter += (n >> i & 1);
        }
        return counter;
    }
}

/*
* Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
* */