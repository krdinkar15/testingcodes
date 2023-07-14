package com.coding.graph.topological;

import com.coding.graph.bfs.Graph;

import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
//        Graph g = new Graph(6);
//        g.addEdge(5, 2);
//        g.addEdge(5, 0);
//        g.addEdge(4, 0);
//        g.addEdge(4, 1);
//        g.addEdge(2, 3);
//        g.addEdge(3, 1);
        Graph g=new Graph(3);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);
        topologicalSort(g);
    }

    static void topologicalSort(Graph g) {
        boolean[] visited=new boolean[g.getN()];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                topologicalSortUtil(g,st,visited,i);
            }
        }
        while (!st.isEmpty())
        {
            System.out.println(st.pop());
        }

    }

    private static void topologicalSortUtil(Graph g, Stack<Integer> st, boolean[] visited,int idx) {
        visited[idx]=true;
        for(int neighbours:g.getAdj()[idx])
        {
            if(!visited[neighbours])
                topologicalSortUtil(g,st,visited,neighbours);
        }
        st.push(idx);
    }

}
