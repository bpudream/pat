package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by bpudream on 15-11-04.
 */
public class Solution130 {
    public void solve(char[][] a) {
        int m = a.length;
        int n = 0;
        if(m > 0) {
            n = a[0].length;
        }
        boolean visited[][] = new boolean[m][n];

        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    if(a[i][j] == 'O') {
                        DFS(a, i, j, m, n, visited);
                    }
                }
            }
        }
    }

    private void DFS(char[][] a, int i, int j, int m, int n, boolean[][] visited) {
        Stack<Pair> stack = new Stack<>();
        ArrayList<Pair> list = new ArrayList<>();
        stack.push(new Pair(i, j));
        list.add(new Pair(i, j));
        boolean bounded = true;

        while(!stack.empty()) {
            Pair p = stack.peek();
            int x = p.x;
            int y = p.y;
            if(x == m - 1 || x == 0 || y == n - 1 || y == 0) {
                bounded = false;
            }
            if(x - 1 >= 0 && !visited[x - 1][y] && a[x - 1][y] == 'O') {
                visited[x - 1][y] = true;
                Pair np = new Pair(x - 1, y);
                stack.push(np);
                list.add(np);
            }
            else if(x + 1 < m && !visited[x + 1][y] && a[x + 1][y] == 'O') {
                visited[x + 1][y] = true;
                Pair np = new Pair(x + 1, y);
                stack.push(np);
                list.add(np);
            }
            else if(y - 1 >= 0 && !visited[x][y - 1] && a[x][y - 1] == 'O') {
                visited[x][y - 1] = true;
                Pair np = new Pair(x, y - 1);
                stack.push(np);
                list.add(np);
            }
            else if(y + 1 < n && !visited[x][y + 1] && a[x][y + 1] == 'O') {
                visited[x][y + 1] = true;
                Pair np = new Pair(x, y + 1);
                stack.push(np);
                list.add(np);
            }
            else {
                stack.pop();
            }
        }

        if(bounded) {
            for(Pair p : list) {
                a[p.x][p.y] = 'X';
            }
        }
    }

    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

/*
* Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
* */