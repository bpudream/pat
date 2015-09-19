/**
 * Created by David on 2015/9/19.
 */
public class Solution045 {
    public int jump(int[] a) {
        int n = a.length;
        int last = 0;
        int far = 0;
        int counter = 0;
        int t[] = new int[n];

        while(far < n - 1) {
            int max = -1;
            int imax = -1;
            for(int i = last; i <= far; i++) {
                if(i + a[i] > max) {
                    max = i + a[i];
                    imax = i;
                }
            }
            if(max == far) {
                counter = Integer.MAX_VALUE;
                break;
            }
            last = imax;
            far = max;
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        Solution045 sol = new Solution045();
//        int a[] = {2,3,1,1,4};
        int a[] = {2,3,0,0,0,0,4};
        System.out.println(sol.jump(a));
    }
}


/*
Jump Game II

* Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
* */