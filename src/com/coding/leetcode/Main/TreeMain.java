package com.coding.leetcode.Main;

import com.coding.leetcode.classes.TreeNode;
import com.coding.leetcode.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMain {
    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir") + "/src/com/sample/lc/testfiles/tree.txt";
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            str = str.substring(1);
            str = str.substring(0, str.length() - 1);
            String[] arr = str.split(",");
            TreeNode root=buidTree(arr);
            Solution s=new Solution();
            System.out.println(s.solve(root));

        }
    }
    public static TreeNode buidTree(String[] arr)
    {
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        int i=1;
        while (!q.isEmpty() && i<arr.length)
        {
            TreeNode currNode=q.remove();
            if(!arr[i].equals("null"))
            {
                currNode.left=new TreeNode(Integer.parseInt(arr[i]));
                q.add(currNode.left);
            }

            i++;
            if(i>=arr.length)
                break;
            if(!arr[i].equals("null"))
            {
                currNode.right=new TreeNode(Integer.parseInt(arr[i]));
                q.add(currNode.right);
            }
            i++;
        }
        return root;

    }

}
