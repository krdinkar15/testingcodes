package com.coding.dp.minMaxPath;

import java.util.Arrays;

public class CoinChange {


    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,999999999);
        dp[0]=0;

        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(i-coins[j]>=0)
                {
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return (dp[amount]==999999999)?-1:dp[amount];
    }

}
