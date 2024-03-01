package com.leetcode.daily.feb;

import com.coding.leetcode.classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Feb28ButtonLeftView {
    public static int findButtonView(TreeNode treeNode)
    {
        // Memory Limit
        Queue<TreeNode> q= new LinkedList<>();
        q.add(treeNode);
        int ans=q.peek().val;
        while(!q.isEmpty())
        {
            TreeNode tr;
            int sz=q.size();
            tr=q.poll();
            for(int i=0;i<sz;i++)
            {
                if(tr.right!=null)
                {
                    ans=tr.right.val;
                    q.add(tr.right);
                }
                if(tr.left!=null)
                {
                    ans=tr.left.val;
                    q.add(tr.left);
                }
                System.out.println(tr);
            }
        }
        return  ans;
    }
    public static int ans=0;
    public static int maxHeight=0;
    public static void dfs(TreeNode treeNode,int height)
    {
        if(treeNode==null)
            return;
        if(treeNode.right!=null)
        {
            dfs(treeNode.right,height+1);
        }
        if(treeNode.left!=null)
        {
            dfs(treeNode.left,height+1);
        }
        if(maxHeight<=height)
        {
            maxHeight=height;
            ans=treeNode.val;
        }
    }
    public static int findButtonViewOptimized(TreeNode treeNode)
    {
        maxHeight=0;
        dfs(treeNode,0);
        return ans;
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.left.left=new TreeNode(4);
        treeNode.right=new TreeNode(3);
        treeNode.right.right=new TreeNode(6);
        treeNode.right.left=new TreeNode(5);
        treeNode.right.left.left=new TreeNode(7);
        System.out.println(findButtonViewOptimized(treeNode));
    }
}
