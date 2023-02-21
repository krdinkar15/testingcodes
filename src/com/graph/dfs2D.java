package com.graph;

import com.graph.common.Pair;

import java.util.Stack;
public class dfs2D {

    static int dx[] = { 0, 1, 0, -1 };
    static int dy[] = { -1, 0, 1, 0 };

    public static boolean isValid(boolean[][] vis,int x,int y)
    {
        if(x<0 || y< 0 || x>=vis.length || y>= vis[0].length)
            return false;
        if(vis[x][y])
            return false;
        return true;
    }
    public static void dfs(int[][] grid) {
        boolean vis[][] = new boolean[3][3];
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, 0));
        while (!st.isEmpty()) {
            Pair curr = st.pop();
            int currX = curr.first;
            int currY = curr.second;
            if (!isValid(vis, currX, currY))
                continue;

            vis[currX][currY] = true;
            System.out.print(grid[currX][currY] + " ");
            for (int i = 0; i < 4; i++) {
                int adjX = currX + dx[i];
                int adjY = currY + dy[i];
                st.push(new Pair(adjX, adjY));
            }

        }
    }
    public static void main(String[] args) {
        int grid[][]={
                {-1,2,3},
                {0,9,8},
                {1,0,1}
        };
        dfs(grid);

    }
}
