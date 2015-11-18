/**
 * Created by David on 2015/11/17.
 */
public class Solution215 {
    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        return find(a, 0, n - 1, k);
    }

    private int find(int[] a, int start, int end, int k) {
        if(end - start < 100) {
            insertionSort(a, start, end);
            return a[end + 1 - k];
        }
        int mid = getmid(a, start, end, (start + end) / 2);
        int bound = start;
        int pivot = a[end];
        for(int i = start; i < end; i++) {
            if(a[i] < pivot && i != bound) {
                int t = a[bound];
                a[bound++] = a[i];
                a[i] = t;
            }
        }
        if(k == end - bound + 1) {
            return a[end];
        }
        else if(k <= end - bound) {
            return find(a, bound, end - 1, k);
        }
        else { // k > end - bound + 1
            return find(a, start, bound - 1, k - (end - bound + 1));
        }
    }

    private void insertionSort(int[] a, int start, int end) {
        for(int i = start + 1; i <= end; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(a[j] <= a[j + 1]) {
                    break;
                }
                // swap j , j+1
                int t = a[j];
                a[j] = a[j + 1];
                a[j + 1] = t;
            }
        }
    }

    // 3 way quick sort
    private int getmid(int[] a, int i, int j, int k) {
        int res = 0;
        if(a[i] > a[j]) {
            if(a[j] > a[k]) {
                res = j;
            }
            else {
                res = a[i] > a[k] ? k : i;
            }
        }
        else {
            if(a[j] < a[k]) {
                res = j;
            }
            else {
                res = a[i] > a[k] ? i : k;
            }
        }
        if(res != j) { // assume j = end
            int t = a[res];
            a[res] = a[j];
            a[j] = t;
        }

        return res;
    }
}

/*
* Find the kth largest element in an unsorted array.
* Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
* */
