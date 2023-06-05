package com.coding.dp.minMaxPath;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n+1][m+1];
        int maxm=Integer.MIN_VALUE;
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans*ans;

    }

    public static void main(String[] args) {
        MaximalSquare mx=new MaximalSquare();
        int ans=mx.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
        System.out.println(ans);
    }
}