/**
 * Created by David on 2015/9/19.
 */
public class Solution073 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                col0 = true;
            }
        }
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                row0 = true;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < n; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if(row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution073 sol = new Solution073();
        int a[][] = {{0,0,0,1},{1,1,1,1},{0,1,1,1},{1,1,1,1},{0,0,1,1}};
        sol.setZeroes(a);
    }
}

/*
* Set Matrix Zeroes
*
* Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
* */