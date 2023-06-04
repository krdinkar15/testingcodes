package com.coding.graph.dfs;

import java.util.ArrayList;
import java.util.List;
// Problem link : https://leetcode.com/problems/time-needed-to-inform-all-employees/
public class TimeNeededToInform {
    int dfs(List<Integer>[] adj,int id,int[] manager,int[] informTime)
    {
        int time=0;
        for(int x:adj[id])
        {
            time=Math.max(time,dfs(adj,x,manager,informTime));
        }
        return time+informTime[id];
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++)
        {
            if(i==headID)
                continue;
            adj[manager[i]].add(i);

        }
        int ans=dfs(adj,headID,manager,informTime);
        return ans;

    }
}
