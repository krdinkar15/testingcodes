package com.leetcode.daily.april;

public class April1_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int lastIndex=s.lastIndexOf(' ');
        return s.length()-lastIndex-1;

    }
    public static void main(String[] args) {
        String s="I am Kamal";
        April1_LengthOfLastWord soln=new April1_LengthOfLastWord();
        System.out.println(soln.lengthOfLastWord(s));
    }
}
