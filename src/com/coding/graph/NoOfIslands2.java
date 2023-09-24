package com.coding.graph;

public class NoOfIslands2 {
    int dx[]=new int[]{1,0,-1,0};
    int dy[]=new int[]{0,1,0,-1};
    boolean isSafe(int x,int y,int n,int m,boolean[][] visited,char[][] grid)
    {
        if(x<0||y<0||x>=n||y>=m||visited[x][y]||grid[x][y]=='0')
            return false;
        return true;

    }
    void dfs(int x,int y,char[][] grid,boolean[][] visited)
    {
        visited[x][y]=true;
        for(int i=0;i<4;i++)
        {
            int currX=x+dx[i];
            int currY=y+dy[i];
            if(isSafe(currX,currY,grid.length,grid[0].length,visited,grid))
            {
                dfs(currX,currY,grid,visited);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==false)
                {
                    ans++;
                    dfs(i,j,grid,visited);
                }
            }

        }
        return ans;
    }
}
