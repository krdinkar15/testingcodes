package com.coding.recursion;
// Problem link : https://leetcode.com/problems/flood-fill/description/
public class FloodFill {
    int[] dx=new int[]{1,0,-1,0};
    int[] dy=new int[]{0,1,0,-1};
    void ff(int[][] image,int sr,int sc,int oldColor,int newColor)
    {
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length || image[sr][sc]!=oldColor)
            return;
        image[sr][sc]=newColor;
        for(int i=0;i<4;i++)
        {
            ff(image,sr+dx[i],sc+dy[i],oldColor,newColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor =image[sr][sc];
        if(oldColor!=newColor)
            ff(image,sr,sc,oldColor,newColor);
        return image;
    }

    public static void main(String[] args) {
        FloodFill f=new FloodFill();
        int[][] ans=f.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2);
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();

        }

    }
}
