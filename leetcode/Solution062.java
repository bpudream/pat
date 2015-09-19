/**
 * Created by David on 2015/9/19.
 */
public class Solution062 {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
         return getPath(res, 0, 0, m, n);
    }

    private int getPath(int[][] a, int x, int y, int m, int n) {
        if(x >= m || y >= n) {
            return 0;
        }
        if(x == m - 1 && y == n - 1) {
            return 1;
        }
        if(a[x][y] == 0) {
            a[x][y] = getPath(a, x + 1, y, m, n) + getPath(a, x, y + 1, m, n);
        }

        return a[x][y];
    }
}

/**
 * Unique Path
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */