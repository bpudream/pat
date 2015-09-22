package leetcode;

/**
 * Created by bpudream on 15-09-21.
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int res = 0;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            int profit = prices[i] - min;
            res = profit > res ? profit : res;
        }

        return res;
    }
}

/*
* Best Time to Buy and Sell Stock
*
* Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
* */