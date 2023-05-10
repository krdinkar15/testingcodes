package com.arrays;
// problem link : https://leetcode.com/problems/spiral-matrix-ii/description/
public class SpiralMatrixGenerate {
    public static int[][]  generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int minrow=0;
        int mincol=0;
        int maxcol=n-1;
        int maxrow=n-1;
        int currsize=0;
        int maxsize=n*n;
        while(currsize<maxsize)
        {
            for(int j=mincol;j<=maxcol;j++)
            {
                currsize++;
                ans[minrow][j]=currsize;
            }
            if(currsize>=maxsize)
                break;
            minrow++;
            for(int i=minrow;i<=maxrow;i++)
            {
                currsize++;
                ans[i][maxcol]=currsize;
            }
            if(currsize>=maxsize)
                break;
            maxcol--;
            for(int j=maxcol;j>=mincol;j--)
            {
                currsize++;
                ans[maxrow][j]=currsize;
            }
            if(currsize>=maxsize)
                break;
            maxrow--;
            for(int i=maxrow;i>=minrow;i--)
            {
                currsize++;
                ans[i][mincol]=currsize;
            }
            if(currsize>=maxsize)
                break;
            mincol++;
        }
        return ans;

    }
    public static void main(String[] args) {
        int[][] ans=generateMatrix(5);
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
