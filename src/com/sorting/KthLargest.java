package com.sorting;
// problem link : https://leetcode.com/problems/kth-largest-element-in-an-array/description/

public class KthLargest {
    public int findPartition(int[] nums,int low,int high)
    {
        int i=low;
        for(int j=low;j<high;j++)
        {
            if(nums[j]<=nums[high])
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        int temp=nums[i];
        nums[i]=nums[high];
        nums[high]=temp;
        return i;
    }
    public int findKthSmallest(int[] nums,int low,int high,int k)
    {
        int pos=findPartition(nums,low,high);
        if(pos-low==k-1)
            return nums[pos];
        else if(pos-low>k-1)
            return findKthSmallest(nums,low,pos-1,k);
        return findKthSmallest(nums,pos+1,high,k-(pos-low+1));
    }
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int kthSmallest=n-k+1;
        return findKthSmallest(nums,0,nums.length-1,kthSmallest);
    }
}