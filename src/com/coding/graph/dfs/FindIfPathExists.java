package com.coding.graph.dfs;

import com.coding.graph.bfs.Graph;

public class FindIfPathExists {
    boolean dfs(int curr,int dest,Graph g,boolean[] visited)
    {
        if(curr==dest)
        {
            return true;
        }
        visited[curr]=true;
        for(int neighbour:g.getAdj()[curr])
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour,dest,g,visited))
                    return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int curr, int dest) {
        Graph g=new Graph(n);
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            g.addEdge(a,b);
        }
        boolean[] visited=new boolean[n];
        return dfs(curr,dest,g,visited);
    }

    public static void main(String[] args) {
        FindIfPathExists f=new FindIfPathExists();
        System.out.println(f.validPath(10,new int[][]{{0,1},{1,2},{2,0}},0,2));
    }
}
