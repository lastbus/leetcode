package com.make.medium;

/**
 * @author make
 * @create 2021-04-13
 */
public class M518_CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int a = coin; a < amount + 1; a++) {
                dp[a] += dp[a - coin];
            }
        }
        return dp[amount];
    }

}
