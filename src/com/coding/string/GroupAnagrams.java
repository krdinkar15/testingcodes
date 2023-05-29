package com.coding.string;

import java.util.*;

//Problem Link : https://leetcode.com/problems/group-anagrams
public class GroupAnagrams {
    public static boolean checkAnagram(String s1,String s2)
    {
        if(s1.length()!=s2.length())
            return false;
        int[] freq=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            char temp=s1.charAt(i);
            freq[temp-'a']++;
        }
        for(int i=0;i<s2.length();i++)
        {
            char temp=s2.charAt(i);
            freq[temp-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(freq[i]!=0)
                return false;
        }
        return true;
    }
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i]==null)
                continue;
            List<String> curr=new ArrayList<>();
            curr.add(strs[i]);
            for(int j=i+1;j<strs.length;j++)
            {
                if(strs[j]==null)
                    continue;

                if(checkAnagram(strs[i],strs[j]))
                {
                    curr.add(strs[j]);
                    strs[j]=null;
                }

            }
            ans.add(curr);
        }
        return ans;
    }
    public static void main(String[] args)
    {
        String[] strs={"eat","tan","ate","nat","bat"};
        List<List<String>> ans=groupAnagrams(strs);
        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }
        System.out.println("---------------");
        List<List<String>> ans2=groupAnagrams2(new String[]{"eat","tan","ate","nat","bat"});
        for(int i=0;i<ans2.size();i++)
        {
            System.out.println(ans2.get(i));
        }
    }
//    ---------------------------   Method 2--------------------------------------------------
    private static List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length==0)
            return new ArrayList<List<String>>();
        Map<String,List<String>> hm=new HashMap<>();
        for(String str:strs)
        {
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);
            if(hm.containsKey(sorted))
            {
                hm.get(sorted).add(str);
            }
            else
            {
                List<String> lst=new ArrayList<String>();
                lst.add(str);
                hm.put(sorted,lst);
            }
        }
        return new ArrayList<List<String>>(hm.values());
    }

}
