package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpudream on 15-09-17.
 */
public class Solution054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if(matrix.length == 0) {
            return list;
        }

        int x = matrix[0].length;
        int y = matrix.length;
        int index = 0;

        while(x > 1 && y > 1) {
            int nx = x - 1;
            int ny = y - 1;

            for(int i = 0; i < nx; i++) { //up
                list.add(matrix[index][index + i]);
            }

            for(int i = 0; i < ny; i++) { // right
                list.add(matrix[index + i][index + nx]);
            }

            for(int i = 0; i < nx; i++) {
                list.add(matrix[index + ny][index + nx - i]); // bottom
            }

            for(int i = 0; i < ny; i++) {
                list.add(matrix[index + ny - i][index]); // left
            }

            index++;
            x -= 2;
            y -= 2;
        }

        if(x == 1) {
            for(int i = 0; i < y; i++) {
                list.add(matrix[index + i][index]);
            }
        }
        else if(y == 1){
            for(int i = 0; i < x; i++) {
                list.add(matrix[index][index + i]);
            }
        }

        return list;
    }
}

/*
Spiral Matrix

* Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
* */