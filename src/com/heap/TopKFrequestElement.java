package com.heap;


import java.util.*;

class Pair implements Comparable<Pair>
{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

   public int compareTo(Pair p)
   {
        return this.first-p.first;
   }
}

public class TopKFrequestElement {
    public static int[] topKFrequent(int[] nums,int k)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(hm.get(nums[i])==null)
                hm.put(nums[i],1);
            else
                hm.put(nums[i],hm.get(nums[i])+1);
        }
        for(Map.Entry<Integer,Integer> temp:hm.entrySet())
        {
            pq.add(new Pair(temp.getValue(), temp.getKey()));
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.peek().second;
            pq.remove();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,2,2,3};
        int[] ans=topKFrequent(nums,2);
        for(int i=0;i<ans.length;i++)
            System.out.println(ans[i]+" ");
    }
}
