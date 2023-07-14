package com.coding.graph.bfs;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int n;
    private List<Integer>[] adj;
    public Graph(int n)
    {
        this.n=n;
        adj=new LinkedList[n];
        for(int i=0;i<n;i++)
            adj[i]=new LinkedList<>();
    }
    public void addEdge(int src,int dest)
    {
        adj[src].add(dest);
    }

    public int getN() {
        return n;
    }

    public List<Integer>[] getAdj() {
        return adj;
    }
}
