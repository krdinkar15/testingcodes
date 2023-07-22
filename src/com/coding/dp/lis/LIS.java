package com.coding.dp.lis;

import java.util.Arrays;

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int[] lis=new int[nums.length];
        Arrays.fill(lis,1);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int maxm=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            maxm=Math.max(maxm,lis[i]);
        }
        return maxm;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));

    }
}
