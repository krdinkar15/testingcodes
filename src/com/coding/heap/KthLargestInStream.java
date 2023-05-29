package com.coding.heap;
// Problem link: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
import java.util.PriorityQueue;

public class KthLargestInStream {

    int k;
    PriorityQueue<Integer> pq;

    public KthLargestInStream(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.remove();
        }

    }
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k)
            pq.remove();
        return pq.peek();

    }
}
