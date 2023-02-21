package com.graph;

import com.graph.common.Pair;

import java.util.Stack;

// Problem Link: https://leetcode.com/problems/number-of-islands/
public class NoOfIslands {
    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};
    public static boolean isValid(boolean[][] visited,int x,int y,char[][] grid)
    {
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length)
            return false;
        if(visited[x][y]==true || grid[x][y]=='0')
            return false;
        return true;

    }
    public static void dfs(char[][] grid,boolean[][] visited,int x,int y)
    {
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(x,y));
        while(!st.empty())
        {
            Pair curr=st.pop();
            int currX=curr.first;
            int currY=curr.second;

            if(!isValid(visited,currX,currY,grid))
                continue;
            visited[currX][currY]=true;
            for(int i=0;i<4;i++)
            {
                int adjX=currX+dx[i];
                int adjY=currY+dy[i];
                st.push(new Pair(adjX,adjY));
            }
        }
    }
    public static int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==false)
                {
                    dfs(grid,visited,i,j);
                    cnt++;
                }
            }
        }
        return cnt;


    }
    public static void main(String[] args)
    {
        char grid[][]={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));


    }
}
