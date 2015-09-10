package elements.E1;

/**
 * Created by bpudream on 15-09-09.
 */
public class E1_7 {
    public void setZeroes(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            if(rows[i]) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < n; j++) {
            if(cols[j]) {
                for(int i = 0; i < m; i++) {
                    a[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        E1_7 e = new E1_7();
        int m = 4, n = 5;
        int a[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = 1 + i + j;
            }
        }

        a[1][3] = 0;
        a[2][3] = 0;

        e.setZeroes(a);

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
