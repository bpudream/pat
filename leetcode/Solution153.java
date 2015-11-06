package leetcode;

/**
 * Created by bpudream on 15-11-06.
 */
public class Solution153 {
    int min = 0;
    public int findMin(int[] a) {
        min = a[0];
        int n = a.length;
        find(a, 0, n - 1);
        return min;
    }

    private void find(int[] a, int start, int end) {
        int m = a[start];
        if(end - start < 10) {
            for(int i = start; i <= end; i++) {
                if(m > a[i]) {
                    m = a[i];
                }
            }
            if(min > m) {
                min = m;
            }
            return;
        }
        int mid = (start + end) / 2;
        if(a[start] < a[mid]) {
            find(a, mid + 1, end);
        }
        else {
            find(a, start, mid);
        }
    }

    public static void main(String[] args) {
        Solution153 sol = new Solution153();
        int[] a = {193,194,198,199,200,204,207,212,214,217,221,225,227,230,231,232,233,235,237,245,247,252,260,262,263,264,265,271,276,284,285,287,296,297,4,9,21,24,25,27,28,29,30,36,40,45,50,55,63,64,65,77,79,100,102,103,107,111,114,118,120,123,126,130,132,134,135,139,142,143,146,147,149,150,151,152,153,157,162,167,170,173,174,176,179,182,183,184,187,189};
        System.out.print(sol.findMin(a));
    }
}

/*
* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
* */