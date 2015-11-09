package leetcode;

/**
 * Created by bpudream on 15-11-08.
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        int counter = 0;
        int m = grid.length;
        if(m == 0) {
            return 0;
        }
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                if(grid[i][j] == '0') {
                    continue;
                }
                search(grid, visited, i, j);
                counter++;
            }
        }

        return counter;
    }

    private void search(char[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i + 1 < m && !visited[i + 1][j] && grid[i + 1][j] == '1') {
            visited[i + 1][j] = true;
            search(grid, visited, i + 1, j);
        }
        if(i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == '1') {
            visited[i - 1][j] = true;
            search(grid, visited, i - 1, j);
        }
        if(j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == '1') {
            visited[i][j + 1] = true;
            search(grid, visited, i, j + 1);
        }
        if(j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == '1') {
            visited[i][j - 1] = true;
            search(grid, visited, i, j - 1);
        }
    }
}

/*
* Given a 2d grid map of '1's (land) and '0's (water),
* count the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
* You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 */
