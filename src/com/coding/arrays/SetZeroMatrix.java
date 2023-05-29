package com.coding.arrays;
// Problem link: https://www.youtube.com/watch?v=7pz2frK7_BM&ab_channel=WorldAffairs

public class SetZeroMatrix {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean[] row=new boolean[n];
        boolean[] cols=new boolean[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=true;
                    cols[j]=true;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(row[i]||cols[j])
                    matrix[i][j]=0;
            }
        }
    }
}
