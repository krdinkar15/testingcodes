package com.coding.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void BFS(int i,Graph g) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        boolean[] visited = new boolean[g.getN()];
        visited[i] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.println(curr);
            for (Integer neighbour : g.getAdj()[curr]) {
                if (visited[neighbour] == false) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }
    public static void main (String[]args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        BFS(2,g);
    }

}
