package com.coding.leetcode.Main;

import com.coding.leetcode.Solution;

public class MatrixMain {

    public static void main(String[] args) {
        int[][] mat={
                {2,1,3},{6,5,4},{7,8,9}
        };
        Solution s=new Solution();
        System.out.println(s.solve(mat));
    }
}
