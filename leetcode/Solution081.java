package leetcode;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution081 {
    public boolean search(int[] a, int target) {
        boolean res = false;

        int n = a.length;
        int start = 0;
        int end = n -1;

        res = searchDeep(a, start, end, target);

        return res;
    }

    boolean searchDeep(int[] a, int start, int end, int target) {
        boolean res = false;
        while(end - start > 10) {
            if(res) {
                break;
            }
            int mid = (start + end) / 2;

            if (a[mid] == target) {
                return true;
            }
            else if (target < a[mid]) {
                if(a[mid] > a[start]) {
                    res = binary(a, start, mid - 1, target);
                    start = mid + 1;
                }
                else {
                    res = searchDeep(a, mid + 1, end, target);
                    end = mid - 1;
                }
            }
            else {
                if(a[mid] < a[end]) {
                    res = binary(a, mid + 1, end, target);
                    end = mid - 1;

                }
                else {
                    res = searchDeep(a, mid + 1, end, target);
                    end = mid - 1;
                }
            }
        }

        for(int i = start; i <= end ;i++) {
            if(a[i] == target) {
                res = true;
            }
        }
        return res;
    }

    boolean binary(int[] a, int i, int j, int target) {
        boolean res = false;

        while(j - i > 10) {
            int mid = (i + j) / 2;
            if(target == a[mid]) {
                return true;
            }
            else if(target < a[mid]) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }

        while(i <= j) {
            if(a[i] == target) {
                return true;
            }
            i++;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution081 sol = new Solution081();
        int[] a = {6,6,6,6,6,6,7,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,-10,-10,-10,-10,-10,-9,-9,-9,-9,-8,-8,-8,-7,-7,-7,-6,-6,-5,-5,-5,-5,-5,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-3,-3,-3,-3,-3,-2,-2,-2,-1,-1,-1,-1,0,0,0,0,0,1,1,1,1,2,2,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,5,5,5,5,5,6,6};
        System.out.println(sol.search(a, 8));
    }
}

/**
 * Search in Rotated Sorted Array II
 *
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */