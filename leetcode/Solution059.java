/**
 * Created by David on 2015/9/19.
 */
public class Solution059 {
    public int[][] generateMatrix(int n) {
        int a[][] = new int[n][n];
        int index = 0;
        int len = n - 1;
        int counter = 1;
        int all = n * n;

        while(counter <= all) {
            if(len == 0) {
                a[index][index] = counter;
                break;
            }
            for(int i = 0; i < len; i++) {
                a[index][index + i] = counter++;
            }

            for(int i = 0; i < len; i++) {
                a[index + i][index + len] = counter++;
            }

            for(int i = 0; i < len; i++) {
                a[index + len][index + len - i] = counter++;
            }

            for(int i = 0; i < len; i++) {
                a[index +len - i][index] = counter++;
            }

            len -= 2;
            index++;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution059 sol = new Solution059();
        sol.generateMatrix(3);
    }
}


/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
