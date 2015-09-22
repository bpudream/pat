package leetcode;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }

        int res = 0;
        int i = 0;
        int low, high;
        while(i < n) {
            while(i + 1 < n && prices[i] >= prices[i + 1]) {
                i++;
            }
            low = prices[i];
            while(i + 1 < n && prices[i] <= prices[i + 1]) {
                i++;
            }
            high = prices[i];
            res += high - low;
            i++;
        }

        return res;
    }
}

/*
Best Time to Buy and Sell Stock II

* Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
* */