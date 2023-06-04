package com.coding.graph.dfs;

import java.util.Arrays;

// link : https://leetcode.com/problems/number-of-provinces/description/

public class NoOfProvince {
    void dfs(int[][] arr,int i,boolean[] visited,int n)
    {
        visited[i]=true;
        for(int j=0;j<n;j++)
        {
            if(arr[i][j]==1 && visited[j]==false)
                dfs(arr,j,visited,n);
        }
    }
    public int findCircleNum(int[][] arr) {
        int n=arr.length;
        boolean[] visited=new boolean[n];
        Arrays.fill(visited,false);
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                cnt++;
                dfs(arr,i,visited,n);
            }
        }
        return cnt;
    }
}
