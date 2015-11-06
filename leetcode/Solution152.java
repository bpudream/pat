package leetcode;

/**
 * Created by bpudream on 15-11-06.
 */
public class Solution152 {
    public int maxProduct(int[] a) {
        int n = a.length;
        int res[] = new int[1];
        res[0] = a[0];
        int counter = 0;
        int first = -1;
        int last = n;
        int start = 0;
        for(int i = 0; i < n; i++) {
            if(a[i] < 0) {
                counter++;
                if(first == -1) {
                    first = i;
                }
                last = i;
            }
            else if(a[i] == 0) {
                if(res[0] < 0) {
                    res[0] = 0;
                }
                getMax(a, start, i, counter, first, last, res);
                start = i+1;
                first = -1;
                counter = 0;
            }
        }


        getMax(a, start, n, counter, first, last, res);


        return res[0];
    }

    private void getMax(int[] a, int start, int end, int counter, int first, int last, int[] res) {
        int n = a.length;

        if(start >= n) {
            return;
        }

        if (counter % 2 == 0) {
            int p = pro(a, start, end);
            if(p > res[0]) {
                res[0] = p;
            }
        } else if (counter == 1){
            int p1 = pro(a, start, first);
            int p2 = pro(a, first + 1, end);
            int p = p1 > p2 ? p1 : p2;
            if(p > res[0]) {
                res[0] = p;
            }
        } else {
            int p1 = pro(a, start, last);
            int p2 = pro(a, first + 1, end);
            int p = p1 > p2 ? p1 : p2;
            if(p > res[0]) {
                res[0] = p;
            }
        }
    }

    private int pro(int[] a, int start, int end) {
        if(start >= end) {
            return Integer.MIN_VALUE;
        }
        int res = 1;
        for(int i = start; i < end; i++) {
            res *= a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution152 sol = new Solution152();
        int[] a = {0,2};
        System.out.println(sol.maxProduct(a));
    }
}

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Subscribe to see which companies asked this question
 */