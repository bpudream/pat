/**
 * Created by David on 2015/6/3.
 */
public class Solution096 {
    static int res[];
    static boolean registed[];
    static boolean first = true;
    public int numTrees(int n) {
        if(res != null && n >= res.length)
            first = true;
        if(first) {
            int m = n;
            if(m < 3)
                m = 3;
            first = false;
            res = new int[m + 1];
            registed = new boolean[m + 1];
            res[0] = res[1] = 1;
            res[2] = 2;
            res[3] = 5;
            registed[0] = registed[1] = registed[2] = registed[3] = true;
        }

        if(registed[n])
            return res[n];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (numTrees(i) * numTrees(n - 1 - i));
        }

        registed[n] = true;
        res[n] = sum;
        return sum;
    }


    public static void main(String[] args) {
        Solution096 sol = new Solution096();
        int res = sol.numTrees(3);
        System.out.println(res);
        res = sol.numTrees(7);
        System.out.println(res);
        res = sol.numTrees(15);
        System.out.println(res);
        res = sol.numTrees(22);
        System.out.println(res);
    }
}

/**
 * Unique binary search trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's
 */