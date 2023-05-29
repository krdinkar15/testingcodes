package com.coding.tree;

import com.coding.leetcode.classes.TreeNode;

import java.util.HashSet;
import java.util.Set;

// question Name : Good Subtrees
// https://practice.geeksforgeeks.org/problems/df12afc57250e7f6fc101aa9c272343184fe9859/1
public class GoodSubtree {
    static int cnt=0;
    public static Set<Integer> findGoodSubtree(TreeNode root, int k)
    {

        if(root==null)
            return new HashSet<>();;
        Set<Integer> sleft=findGoodSubtree(root.left,k);
        Set<Integer> sright=findGoodSubtree(root.right,k);
        Set<Integer> temp=new HashSet<>();
        temp.add(root.val);
        temp.addAll(sleft);
        temp.addAll(sright);
        if(temp.size()<=k)
            cnt++;
        return temp;
    }
    public static int goodSubtrees(TreeNode root,int k)
    {
        if(root==null)
            return 0;
        cnt=0;
        findGoodSubtree(root,k);
        return cnt;
    }
}
