package leetcode;

/**
 * Created by bpudream on 15-09-17.
 */
public class Solution036 {
    public final static int SUDOKU = 9;
    public boolean isValidSudoku(char[][] board) {
        boolean res = true;

        for(int i = 0; i < SUDOKU; i++) {
            boolean check[] = new boolean[SUDOKU];
            for(int j = 0; j < SUDOKU; j++) {
                if(board[i][j] >= '1' && board[i][j] <= '9') {
                    int index = board[i][j] - '1';
                    if(check[index]) {
                        return false;
                    }
                    check[index] = true;
                }
            }
        }

        for(int j = 0; j < SUDOKU; j++) {
            boolean check[] = new boolean[SUDOKU];
            for(int i = 0; i < SUDOKU; i++) {
                if(board[i][j] >= '1' && board[i][j] <= '9') {
                    int index = board[i][j] - '1';
                    if(check[index]) {
                        return false;
                    }
                    check[index] = true;
                }
            }
        }

        for(int i = 0; i < SUDOKU; i += 3) {
            for(int j = 0; j < SUDOKU; j += 3) {
                boolean check[] = new boolean[SUDOKU];
                for(int a = 0; a < SUDOKU / 3; a++) {
                    for(int b = 0; b < SUDOKU / 3; b++) {
                        if(board[i + a][j + b] >= '1' && board[i + a][j + b] <= '9') {
                            int index = board[i + a][j + b] - '1';
                            if(check[index]) {
                                return false;
                            }
                            check[index] = true;
                        }
                    }
                }
            }
        }

        return res;
    }
}

/*
Valid Sudoku

* Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
* */