package com.coding.graph.topological;

import com.coding.graph.bfs.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class DetectLoopTopological {
    public static void main(String[] args) {

        Graph g=new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        Stack<Integer> reverseTopo=topologicalSort(g);
        System.out.println(checkLoop(g,reverseTopo));
    }



    private static Stack topologicalSort(Graph g) {
        boolean[] visited=new boolean[g.getN()];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i]) {
                topologicalSortUtil(g, st, visited,i);
            }
        }
        return st;
    }
    private static void topologicalSortUtil(Graph g,Stack<Integer> st,boolean[] visited,int idx)
    {
        visited[idx]=true;
        for(int neighbour:g.getAdj()[idx])
        {
            if(!visited[idx])
            {
                topologicalSortUtil(g,st,visited,neighbour);
            }
        }
        st.push(idx);
    }


    private static boolean checkLoop(Graph g, Stack<Integer> st) {
        Map<Integer,Integer> hm=new HashMap<>();
        int pos=0;
        while (!st.isEmpty())
        {
            hm.put(st.pop(),pos++);
        }
        for(int parent=0;parent<g.getN();parent++)
        {
            for(int child:g.getAdj()[parent])
            {
                if(hm.get(parent)>hm.get(child))
                    return true;
            }
        }
        return false;
    }
}
