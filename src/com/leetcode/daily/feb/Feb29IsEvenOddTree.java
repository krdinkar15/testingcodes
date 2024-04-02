package com.leetcode.daily.feb;

import com.coding.leetcode.classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Feb29IsEvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val%2==0)
            return false;
        else
        {
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            int level=1;
            while(!queue.isEmpty())
            {
                int sz=queue.size();
                TreeNode curr=queue.poll();

                for(int i=0;i<sz;i++)
                {
                    if(level%2==1)
                    {
                        if(curr.right!=null)
                        {
                            queue.add(curr.right);
                        }
                        if(curr.left!=null)
                        {
                            queue.add(curr.left);
                        }
                    }
                    else
                    {
                        if(curr.left!=null)
                        {
                            queue.add(curr.left);
                        }
                        if(curr.right!=null)
                        {
                            queue.add(curr.right);
                        }
                    }

                }
                level++;
            }
        }
        return false;


    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(9);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(5);
        treeNode.right=new TreeNode(1);
        treeNode.right.right=new TreeNode(6);
        treeNode.right.left=new TreeNode(7);
        Feb29IsEvenOddTree Feb29IsEvenOddTree=new Feb29IsEvenOddTree();
        System.out.println(Feb29IsEvenOddTree.isEvenOddTree(treeNode));
    }
}
