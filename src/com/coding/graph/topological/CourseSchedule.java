package com.coding.graph.topological;

import com.coding.graph.bfs.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// leetcode : https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule {
    public boolean canFinish(int n, int[][] prerequisites) {
        Graph g=new Graph(n);
        for(int i=0;i<prerequisites.length;i++)
        {
            g.addEdge(prerequisites[i][1],prerequisites[i][0]);
        }
        Stack<Integer> reverseTopo=topologicalSort(g,n);
        return !checkLoop(g,reverseTopo,n);

    }
    public static Stack topologicalSort(Graph g,int n)
    {
        boolean[] visited=new boolean[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                topologicalUtil(g,visited,st,i);
            }
        }
        return st;
    }
    public static void topologicalUtil(Graph g,boolean[] visited,Stack<Integer> st,int idx)
    {
        visited[idx]=true;
        for(int neighbour:g.getAdj()[idx])
        {
            if(!visited[neighbour])
            {
                topologicalUtil(g,visited,st,neighbour);
            }
        }
        st.push(idx);
    }
    public boolean checkLoop(Graph g,Stack<Integer> st,int n)
    {
        Map<Integer,Integer> hm=new HashMap<>();
        int pos=0;
        while(!st.isEmpty())
        {
            hm.put(st.pop(),pos++);
        }
        for(int parent=0;parent<n;parent++)
        {
            for(int child:g.getAdj()[parent])
            {
                if(hm.get(parent)>=hm.get(child))
                    return true;
            }
        }
        return false;
    }
}
