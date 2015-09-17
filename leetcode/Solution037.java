package leetcode;

/**
 * Created by bpudream on 15-09-17.
 */
public class Solution037 {

    boolean rowCheck[][] = new boolean[9][9];
    boolean colCheck[][] = new boolean[9][9];
    boolean blockCheck[][][] = new boolean[3][3][9];
    int counter = 0;
    boolean found = false;
    int systemcalls = 0;

    public void solveSudoku(char[][] board) {

        // Assume the existed board is valid.
        int a[][] = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    a[i][j] = 0;
                }
                else {
                    counter++;
                    a[i][j] = board[i][j] - '0';
                    rowCheck[i][a[i][j] - 1] = true;
                    colCheck[j][a[i][j] - 1] = true;
                    blockCheck[i / 3][j / 3][a[i][j] - 1] = true;
                }
            }
        }

        solver(board, a);
        System.out.println("run time: " + systemcalls);
    }

    private void solver(char[][] board, int[][] a) {
        systemcalls++;

        if(counter == 81) {
            found = true;
            for(int x = 0; x < 9; x++) {
                for(int y = 0; y < 9; y++) {
                    board[x][y] = (char)('0' + a[x][y]);
                }
            }
            return;
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(a[i][j] != 0) {
                    continue;
                }

                int k;
                for(k = 0; k < 9 && !found; k++) {
                    if(!blockCheck[i / 3][j / 3][k]) {
                        if(!rowCheck[i][k] && !colCheck[j][k]) {
                            a[i][j] = k + 1;
                            blockCheck[i / 3][j / 3][k] = true;
                            rowCheck[i][k] = true;
                            colCheck[j][k] = true;
                            counter++;
                            solver(board, a);
                            a[i][j] = 0;
                            counter--;
                            rowCheck[i][k] = false;
                            colCheck[j][k] = false;
                            blockCheck[i / 3][j / 3][k] = false;
                        }
                    }
                }
                if(k == 9 && a[i][j] == 0) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] board = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char[][] b = new char[9][9];
        for(int k = 0; k < 9; k++) {
            String s = board[k];
            for(int i = 0; i < 9; i++) {
                b[k][i] = s.charAt(i);
            }
        }

        Solution037 sol = new Solution037();
        sol.solveSudoku(b);
    }

}


/*
Sudoku Solver

* Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
* */