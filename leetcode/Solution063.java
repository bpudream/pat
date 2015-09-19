/**
 * Created by David on 2015/9/19.
 */
public class Solution063 {
    int m, n;
    int[][] a;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        a = new int[m][n];
        for(int i= 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = -1;
            }
        }
        return getPath(obstacleGrid, 0, 0);
    }


    private int getPath(int[][] ob, int x, int y) {
        if(x >= m || y >= n) {
            return 0;
        }
        if(x == m - 1 && y == n - 1 && ob[x][y] == 0) {
            return 1;
        }
        if(a[x][y] == -1) {
            if(ob[x][y] == 1) {
                a[x][y] = 0;
            }
            else {
                a[x][y] = getPath(ob, x + 1, y) + getPath(ob, x, y + 1);
            }
        }

        return a[x][y];
    }
}

/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
* */