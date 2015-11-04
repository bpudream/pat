package leetcode;

/**
 * Created by bpudream on 15-11-04.
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] next = new int[n];
        int[] sum = new int[n];

        for(int i = 0; i < n; i++) {
            next[i] = i;
            sum[i] = gas[i] - cost[i];
        }

        int i = 0;
        for(i = 0; i < n; i++) {
            if(sum[i] < 0) {
                continue;
            }
            int j = i + 1;
            j %= n;
            while(sum[i] >= 0 && j != i) {
                if (next[j] != j) {
                    sum[i] += sum[j];
                    j = next[j];
                }
                sum[i] += gas[j] - cost[j];
                j++;
                j %= n;
            }

            if(sum[i] >= 0 && j == i) {
                break;
            }
            else {
                j = (n + j - 1) % n;
                next[i] = j;
                sum[i] -= gas[j] - cost[j];
            }
            if(next[i] > i) {
                i = next[i];
            }
        }

        if(i == n) {
            i = -1;
        }

        return i;
    }

    public static void main(String[] args) {
        int[] a = {-1,0};
        int[] b = {0,0,0,0};
        Solution134 sol = new Solution134();
        System.out.println(sol.canCompleteCircuit(a, b));
    }
}


/*
* There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
* */