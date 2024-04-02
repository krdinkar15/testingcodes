package com.leetcode.daily.march;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            ans[i]=nums[i]*nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
    public int[] sortedSquaresTwoPointer(int[] nums) {
        int size=nums.length;
        int i=0;
        int j=size-1;
        int[] ans=new int[nums.length];
        while(i<=j)
        {
            if(nums[i]*nums[i]<=nums[j]*nums[j])
            {
                size--;

                ans[size]=nums[j]*nums[j];
                j--;

            }
            else
            {
                size--;
                ans[size]=nums[i]*nums[i];
                i++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr={-7,-3,2,3,11};
        SquaresOfSortedArray sq=new SquaresOfSortedArray();
        System.out.println(sq.sortedSquaresTwoPointer(arr));

    }

}
