package com.coding.graph.bfs;

import com.coding.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
class Graph1
{
    private int n;
    private List<Integer>[] adj;
    Graph1(int n)
    {
        this.n=n;
        adj=new LinkedList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new LinkedList<>();
        }
    }
    void addEdge(int src,int dest)
    {
        adj[src].add(dest);
        adj[dest].add(src);
    }
    void BFS(int src,int k,List<Integer> ans)
    {
        boolean[] visited=new boolean[600];
        visited[src]=true;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(src);
        int[] level=new int[600];
        level[src]=0;
        while(!queue.isEmpty())
        {
            Integer curr=queue.poll();
            if(level[curr]==k)
            {
                ans.add(curr);
            }
            if(level[curr]>k)
                break;
            for(Integer neighbour:adj[curr])
            {
                if(visited[neighbour]==false)
                {
                    visited[neighbour]=true;
                    level[neighbour]=level[curr]+1;
                    queue.add(neighbour);
                }
            }

        }
    }
}
public class AllNodesAtDistanceK {
    int nodes=0;
    Graph1 g=new Graph1(600);
    void preorder(TreeNode root)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        if(root.left!=null)
        {
            g.addEdge(root.val,root.left.val);
        }
        if(root.right!=null)
        {
            g.addEdge(root.val,root.right.val);
        }
        preorder(root.left);
        preorder(root.right);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        preorder(root);
        g.BFS(target.val,k,ans);
        return ans;
    }
}