package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxsize=n*m;
        int currsize=0;
        int minrow=0;
        int maxrow=matrix.length-1;
        int mincol=0;
        int maxcol=matrix[0].length-1;
        List<Integer> ans=new ArrayList<>();
        while(currsize<maxsize)
        {
            for(int j=mincol;j<=maxcol;j++)
            {
                ans.add(matrix[minrow][j]);
                currsize++;
            }
            if(currsize>=maxsize)
                break;
            minrow++;
            for(int i=minrow;i<=maxrow;i++)
            {
                ans.add(matrix[i][maxcol]);
                currsize++;

            }
            if(currsize>=maxsize)
                break;
            maxcol--;
            for(int j=maxcol;j>=mincol;j--)
            {
                ans.add(matrix[maxrow][j]);
                currsize++;

            }
            if(currsize>=maxsize)
                break;
            maxrow--;
            for(int i=maxrow;i>=minrow;i--)
            {
                ans.add(matrix[i][mincol]);
                currsize++;

            }
            if(currsize>=maxsize)
                break;
            mincol++;
        }
        return ans;
    }
}
