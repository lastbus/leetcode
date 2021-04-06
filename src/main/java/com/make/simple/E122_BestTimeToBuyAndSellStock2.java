package com.make.simple;

/**
 * @author make
 * @create 2021-04-01
 */
public class E122_BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};

        System.out.println(maxProfit(a));

    }


    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

}
