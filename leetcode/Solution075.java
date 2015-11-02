package leetcode;

/**
 * Created by bpudream on 15-11-02.
 */
public class Solution075 {
    public void sortColors(int[] a) {
        int length = a.length;
        int oneright = -1, threeleft = length;
        int i = 0;
        for(i = 0; i < length; i++) {
            if(a[i] != 0) {
                break;
            }
        }
        oneright = i - 1;

        for(i = length - 1; i >= 0; i--) {
            if(a[i] != 2) {
                break;
            }
        }
        threeleft = i + 1;

        for(int j = oneright + 1; j < threeleft; j++) {
            if(a[j] == 0) {
                a[j] = a[++oneright];
                a[oneright] = 0;
            }
            else if(a[j] == 2) {
                a[j] = a[--threeleft];
                a[threeleft] = 2;
                j--;
            }
        }
    }
}

/*
* Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
* with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
* */