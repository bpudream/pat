package leetcode;

/**
 * Created by bpudream on 15-09-20.
 */
public class Solution079 {
    int m, n;
    boolean table[][];
    boolean res;

    public boolean exist(char[][] board, String word) {
        if(word == null) {
            return true;
        }
        res = false;
        if(board == null || board.length == 0) {
            return res;
        }
        m = board.length;
        n = board[0].length;
        table = new boolean[m][n];

        char first = word.charAt(0);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == first) {
                    table = new boolean[m][n];
                    table[i][j] = true;
                    DFS(board, word, i, j, 1);
                }
                if(res) {
                    return res;
                }
                table[i][j] = false;
            }
        }

        return res;
    }

    void DFS(char[][] board, String word, int i, int j, int index) {
        if(res) {
            return;
        }
        if(index >= word.length()) {
            res = true;
            return;
        }

        char c = word.charAt(index);

        if(j + 1 < n) {
            if(!table[i][j + 1] && board[i][j + 1] == c) {
                table[i][j + 1] = true;
                DFS(board, word, i, j + 1, index + 1);
                table[i][j + 1] = false;
            }
        }

        if(i + 1 < m) {
            if(!table[i + 1][j] && board[i + 1][j] == c) {
                table[i + 1][j] = true;
                DFS(board, word, i + 1, j, index + 1);
                table[i + 1][j] = false;
            }
        }

        if(i > 0) {
            if (!table[i - 1][j] && board[i - 1][j] == c) {
                table[i - 1][j] = true;
                DFS(board, word, i - 1, j, index + 1);
                table[i - 1][j] = false;
            }
        }

        if(j > 0) {
            if (!table[i][j - 1] && board[i][j - 1] == c) {
                table[i][j - 1] = true;
                DFS(board, word, i, j - 1, index + 1);
                table[i][j - 1] = false;
            }
        }
    }
}


/*
Word Search

* Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*
* */