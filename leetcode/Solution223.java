package leetcode;

/**
 * Created by bpudream on 15-11-23.
 */
public class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = 0;
        int x = 0, y = 0;

        if(A < E) {
            x = calX(A, C, E, G);
        }
        else {
            x = calX(E, G, A, C);
        }

        if(D > H) {
            y = calY(B, D, F, H);
        }
        else {
            y = calY(F, H, B, D);
        }

        res = area(A,B,C,D) + area(E,F,G,H) - x * y;

        return res;
    }

    private int area(int a, int b, int c, int d) {
        return (c - a) * (d - b);
    }

    private int calX(int A, int C, int E, int G) {
        int x = 0;
        if(C <= E) {
            ;
        }
        else if(C >= G) {
            x = G - E;
        }
        else {
            x = C - E;
        }
        return x;
    }

    private int calY(int B, int D, int F, int H) {
        int y = 0;
        if(B >= H) {
            ;
        }
        else if(B <= F) {
            y = -F + H;
        }
        else {
            y = H - B;
        }
        return y;
    }
}

/*
* Find the total area covered by two rectilinear rectangles in a 2D plane.
* */