package leetcode;

/**
 * Created by bpudream on 15-11-08.
 */
public class Solution190 {
    public int reverseBits(int n) {
        int sum = 0;
        StringBuffer sb = new StringBuffer("");
        for(int i = 0 ; i < 32; i++) {
            int bit = n >> i & 1;
            sum = (sum << 1) + bit;
            sb.append(bit);
        }
        System.out.println(sb.toString() + "\n" + sum);
        return sum;
    }

    public static void main(String[] args) {
        Solution190 sol = new Solution190();
        sol.reverseBits(1);
    }
}

/*
* Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
* */