package com.coding.dp.minMaxPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Link : https://leetcode.com/problems/triangle/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                if(i==0)
                    dp[0][0]=triangle.get(0).get(0);

                else if(j==0)
                {
                    dp[i][j]=dp[i-1][0]+triangle.get(i).get(j);
                }
                else if(j==triangle.get(i).size()-1)
                {
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;

    }
    public static void main(String[] args) {
        Triangle t = new Triangle();
        int ans = t.minimumTotal(new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(2));
                add(Arrays.asList(3, 4));
                add(Arrays.asList(6, 5, 7));
                add(Arrays.asList(4, 1, 8, 3));
            }
        });
        System.out.println(ans);
    }
}
