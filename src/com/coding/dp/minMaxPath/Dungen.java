package com.coding.dp.minMaxPath;

public class Dungen {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] dp=new int[n][m];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(i==n-1 && j==m-1)
                    dp[i][j]=Math.min(0,dungeon[i][j]);
                else if(i==n-1)
                {
                    dp[i][j]=Math.min(0,(dp[i][j+1]+dungeon[i][j]));
                }
                else if(j==m-1)
                {

                    dp[i][j]=Math.min(0,dp[i+1][j]+dungeon[i][j]);
                }
                else
                {
                    dp[i][j]=Math.min(0,dungeon[i][j]+Math.max(dp[i][j+1],dp[i+1][j]));
                }
            }
        }
        if(dp[0][0]>0)
            return 0;
        return -(dp[0][0]-1);

    }
    public static void main(String[] args) {
        Dungen d=new Dungen();
        int ans=d.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}});
        System.out.println(ans);

    }
}
