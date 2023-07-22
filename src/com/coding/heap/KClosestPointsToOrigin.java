package com.coding.heap;

import java.util.PriorityQueue;
// https://leetcode.com/problems/k-closest-points-to-origin/description/
class Triplet implements Comparable<Triplet>
{
    double a;
    int b;
    int c;
    public Triplet(double a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public int compareTo(Triplet t)
    {
        if(this.a-t.a>0)
            return 1;
        else if(this.a-t.a<0)
            return -1;
        return 0;
    }
}
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans=new int[k][2];
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        for(int i=0;i<points.length;i++)
        {
            int x=points[i][0];
            int y=points[i][1];
            double dist=Math.sqrt(x*x+y*y);
            Triplet t=new Triplet(dist,x,y);
            pq.add(t);
        }
        for(int i=0;i<k;i++)
        {
            Triplet t=pq.remove();
            ans[i][0]=t.b;
            ans[i][1]=t.c;
        }
        return ans;

    }
}