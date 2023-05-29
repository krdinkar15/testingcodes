package com.coding.stack;

import java.util.Stack;
// problem link : https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public static boolean checkBracket(char x)
    {
        if(x=='{' || x== '[' || x=='(')
            return true;
        return false;
    }
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char temp=s.charAt(i);
            if(checkBracket(temp))
            {
                st.push(temp);
            }
            else
            {
                if(st.size()==0)
                    return false;
                else
                {
                    char p=st.pop();
                    if(s.charAt(i)==')')
                    {
                        if(p=='(')
                            continue;
                        else
                            return false;
                    }
                    else if(s.charAt(i)=='}')
                    {
                        if(p=='{')
                            continue;
                        else
                            return false;
                    }
                    else if(s.charAt(i)==']')
                    {
                        if(p=='[')
                            continue;
                        else
                            return false;
                    }
                }
            }
        }
        if(st.size()==0)
            return true;
        return false;

    }

    public static void main(String[] args) {
        String str="()[]{}";
        System.out.println(isValid(str));
    }
}
