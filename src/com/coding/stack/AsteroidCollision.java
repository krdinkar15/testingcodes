package com.coding.stack;

import java.util.Stack;

public class AsteroidCollision {
    public boolean sameSign(int a,int b)
    {
        if( (a>0 && b>0) || (a<0 && b<0))
            return true;
        return false;
    }
    public void popOut(Stack<Integer> st,int x)
    {
        while(st.isEmpty()==false)
        {
            st.pop();
            if(st.size()==0)
            {
                st.push(x);
                return;
            }
            if(st.peek()<0 && x<0)
            {
                st.push(x);
                return;
            }
            else if(Math.abs(st.peek())==Math.abs(x))
            {
                st.pop();
                return;
            }
            if(Math.abs(st.peek())>Math.abs(x))
            {
                return;
            }
        }
    }
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            if(st.size()==0)
            {
                st.push(arr[i]);
            }
            else
            {
                if(sameSign(st.peek(),arr[i]))
                {
                    //+ +    - -
                    st.push(arr[i]);
                }
                else
                {
                    if(st.peek()<0 &&  arr[i]>0)
                    {
                        // - +
                        st.push(arr[i]);
                    }
                    else
                    {
                        // + -
                        if(Math.abs(st.peek())==Math.abs(arr[i]))
                        {
                            st.pop();
                        }
                        else if(Math.abs(st.peek())>Math.abs(arr[i]))
                        {
                            continue;
                        }
                        else
                        {
                            popOut(st,arr[i]);
                        }
                    }
                }
            }

        }
        int n=st.size();
        if(n==0)
            return new int[]{};
        int[] ans=new int[n];
        while(!st.isEmpty())
        {
            ans[n-1]=st.pop();
            n--;
        }
        return ans;
    }
    public static void main(String[] args) {
        AsteroidCollision obj=new AsteroidCollision();
       int[] ans= obj.asteroidCollision(new int[]{-2,-2,1,-2});
//       int[] ans= obj.asteroidCollision(new int[]{1,-2,-2,-2});
       for(int i=0;i<ans.length;i++)
       {
           System.out.println(ans[i]+" ");
       }
    }

}
