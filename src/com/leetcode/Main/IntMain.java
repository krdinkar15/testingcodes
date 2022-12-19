package com.leetcode.Main;

import com.leetcode.Solution;

import java.io.*;

public class IntMain {
    public static void main(String[] args) throws IOException {
       int[] nums=new int[]{2,3,4,5};
       for(int num:nums)
       {
           Solution s=new Solution();
           System.out.println(s.solve(num));
       }
    }
}
