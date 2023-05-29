package com.coding.tree;

import com.coding.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    // ------------------------------   Recursive --------------------------------------------
    List<Integer> ans=new ArrayList<>();
    public void inorder(TreeNode root)
    {
        if(root==null)
            return ;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ans.clear();
        inorder(root);
        return ans;
    }






    // -------------------------------  Iterative------------------------------------


}
