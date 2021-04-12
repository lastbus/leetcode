package com.make.medium;

/**
 * @author make
 * @create 2021-04-12
 */
public class M322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        count[0] = 0;
        for (int i = 1; i <= amount; i++) {
            count[i] = amount + 1;
            for (int coin : coins) {
                if (i < coin) continue;
                count[i] = Math.min(count[i], count[i - coin] + 1);
            }
        }
        return (count[amount] == amount + 1) ? -1 : count[amount];
    }

}
