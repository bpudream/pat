/**
 * Created by David on 2015/11/7.
 */
public class Solution162 {
    public int findPeakElement(int[] a) {
        int n = a.length;
        if(n <= 1) {
            return 0;
        }
        if(a[0] > a[1]) {
            return 0;
        }
        int i = 1;
        for(i = 1; i < n - 1; i++) {
            if(a[i] > a[i - 1] && a[i] > a[i + 1]) {
                break;
            }
        }
        return i;
    }
}

/*
* A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -¡Þ.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
* */