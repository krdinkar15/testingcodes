package com.leetcode.daily.april;

import java.util.HashMap;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Character> hashMap=new HashMap();
        for(int i=0;i<s.length();i++)
        {
            if(hashMap.containsKey(s.charAt(i)))
            {
                if(t.charAt(i)!=hashMap.get(s.charAt(i)))
                {
                    return false;
                }
            }
            else
            {
                if(hashMap.containsValue(t.charAt(i)))
                    return false;
                hashMap.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s="badc";
        String t="baba";
        IsomorphicString isomorphicString=new IsomorphicString();
        System.out.println(isomorphicString.isIsomorphic(s,t));
    }
}
