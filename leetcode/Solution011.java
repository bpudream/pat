package leetcode;

/**
 * Created by bpudream on 15-09-13.
 */
public class Solution011 {
    public int maxArea(int[] height) {
        int res = 0;
        int n = height.length;

        res = 0;
        int a = 0, b = n - 1;
        int min = 0, area = 0;
        boolean isLeft = false;
        while(a < b) {
            if(height[a] < height[b]) {
                min = height[a];
                isLeft = true;
            }
            else {
                min = height[b];
                isLeft = false;
            }
            area = (b - a) * min;
            res = res > area ? res : area;
            if(isLeft) {
                a++;
            }
            else {
                b--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution011 sol = new Solution011();
        int arr[] = {1,2,4,3};
        System.out.println(sol.maxArea(arr));
    }
}


/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
* */