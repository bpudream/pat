package leetcode;

/**
 * Created by bpudream on 15-11-19.
 */
public class Solution221 {
    public int maximalSquare(char[][] arr) {
        int m = arr.length;
        if(m == 0) {
            return 0;
        }
        int n = arr[0].length;

        int[][] a = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == '1') {
                    a[i][j] = 1;
                }
            }
        }

        int count = 0;
        boolean found = true;
        while(found) {
            found = false;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(a[i][j] == 1) {
                        found = true;
                        if(i + 1 < m && j + 1 < n) {
                            a[i][j] = a[i + 1][j] * a[i][j + 1] * a[i + 1][j + 1];
                        }
                        else {
                            a[i][j] = 0;
                        }
                    }
                }
            }
            count++;
        }
        count--;
        return count * count;
    }

}
