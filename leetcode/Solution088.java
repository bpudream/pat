package leetcode;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution088 {
    public void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >=0 && j >= 0) {
            if(a[i] > b[j]) {
                a[k--] = a[i--];
            }
            else {
                a[k--] = b[j--];
            }
        }
        if(j >= 0) {
            for(j = j; j >= 0; j--) {
                a[k--] = b[j];
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {4,5,6,0,0,0};
        int[] b = {1,2,3};
        Solution088 sol = new Solution088();
        sol.merge(a, 3, b, 3);
    }
}

/*
Merge Sorted Array

* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
The number of elements initialized in nums1 and nums2 are m and n respectively.
* */