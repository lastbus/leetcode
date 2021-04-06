package com.make.simple;

/**
 * @author make
 * @create 2021-04-01
 */
public class E121_Stock {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
