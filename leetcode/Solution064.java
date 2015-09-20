/**
 * Created by David on 2015/9/19.
 */
public class Solution064 {
    public int minPathSum(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] path = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                path[i][j] = Integer.MAX_VALUE;
            }
        }

        path[0][0] = a[0][0];

        for(int i = 1; i < m; i++) {
            path[i][0] = path[i - 1][0] + a[i][0];
        }
        for(int j = 1; j < m; j++) {
            path[0][j] = path[0][j - 1] + a[0][j];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] < path[i][j - 1] ? path[i - 1][j] : path[i][j - 1] + a[i][j];
            }
        }
        return path[m - 1][n - 1];
    }
}

/*
* Minimum Path Sum
*
* Given a m x n grid filled with non-negative numbers,
* find a path from top left to bottom right which minimizes the sum of all numbers along its path.
*
* Note: You can only move either down or right at any point in time.
* */