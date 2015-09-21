package leetcode;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution080 {
    public int removeDuplicates(int[] a) {
        int n = a.length;
        if(n == 0) {
            return 0;
        }
        int index = 1;
        boolean dup = false;
        for(int i = 1; i < n; i++) {
            if(a[i] != a[i - 1]) {
                dup = false;
                a[index++] = a[i];
            }
            else if(a[i] == a[i - 1] && !dup) {
                dup = true;
                a[index++] = a[i];
            }
        }

        return index;
    }
}

/*
* Remove Duplicates From Sorted Array
*
* Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5,
 with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.
* */