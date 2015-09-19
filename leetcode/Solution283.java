/**
 * Created by David on 2015/9/19.
 */
public class Solution283 {
    public void moveZeroes(int[] a) {
        int n = a.length;
        int counter = 0;
        int index = 0;
        while(index < n) {
            if(a[index] != 0) {
                a[counter++] = a[index];
            }
            index++;
        }
        for(int i = counter; i< n; i++) {
            a[i] = 0;
        }
    }
}

/*
* Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
* */