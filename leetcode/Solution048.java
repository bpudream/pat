package leetcode;

/**
 * Created by bpudream on 15-09-16.
 */
public class Solution048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int index = 0;

        while(n > 0) {
            int length = n - 1;
            int[] temp = new int[length];

            for(int i = 0; i < length; i++) {
                temp[i] = matrix[index][index + i]; // "keep up"
            }

            for(int i = 0; i < length; i++) { // copy left to up
                matrix[index][index + i] = matrix[index + length - i][index];
            }

            for(int i = 0; i < length; i++) {  // copy bottom to left;
                matrix[index + 1 + i][index] = matrix[index + length][index + 1 + i];
            }

            for(int i = 0; i < length; i++) {
                matrix[index + length][index + 1 + i] = matrix[index + length - 1 - i][index + length]; // copy right to bottom
            }

            for(int i = 0; i < length; i++) {  // copy up to right;
                matrix[index + i][index + length] = temp[i];
            }

            n -= 2;
            index++;
        }
    }
}

/**
 * Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 *
 */