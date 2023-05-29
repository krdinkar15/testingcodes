package com.coding.string;
// Problem link : https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordsInString {
    public static String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==' ')
                continue;
            int j=i;
            while(i>=0 && s.charAt(i)!=' ')
            {
                i--;
            }
            sb.append(s.substring(i+1,j+1));
            sb.append(' ');
        }
        return sb.toString().trim();

    }

    public static void main(String[] args) {
        String str="the sky is blue";
        System.out.println(reverseWords(str));
    }
}
