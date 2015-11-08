package leetcode;

/**
 * Created by bpudream on 15-11-08.
 */
public class Solution189 {
    public void rotate(int[] a, int k) {
        int n = a.length;
        if(k % n == 0) {
            return;
        }

        int d = gcd(n, k);

        for(int i = 0; i < d; i++) {
            int start = i;
            int out = a[start];
            int next = (start + k) % n;
            while(next != start) {
                int t = a[next];
                a[next] = out;
                out = t;
                next = (next + k) % n;
            }
            a[next] = out;
        }
    }

    private int gcd(int a, int b) {
        int m;
        while(a % b != 0) {
            m = a % b;
            a = b;
            b = m;
        }
        return b;
    }
}

/*
* Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?

* */