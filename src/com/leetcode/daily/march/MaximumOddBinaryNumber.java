package com.leetcode.daily.march;

public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder ans=new StringBuilder();
        int zeroCount=0;
        int oneCount=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='0')
            {
                zeroCount++;
            }
            else {
                oneCount++;
            }
        }
        for(int i=0;i<oneCount-1;i++)
        {
            ans.append('1');
        }
        for(int i=0;i<zeroCount;i++)
        {
            ans.append('0');
        }
        ans.append('1');
        return ans.toString();
    }
    public static void main(String[] args) {
        String str="0101";
        MaximumOddBinaryNumber maximumOddBinaryNumber=new MaximumOddBinaryNumber();
        System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber(str));
    }
}