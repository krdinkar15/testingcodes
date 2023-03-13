package com.stack;

import java.util.Stack;

public class NextGreaterElement {
    public static int[] getNextGreaterElement (int[] A) {

    //        Right to Left Traversal
    //        we will not push the element on the stack .
    //        we will push index of that element.
    //        Popping the element and setting the NGR will be done at the same time.
    //        The element which has popped is definetly greater element.
    //        All those elements which are not popped has no NGR.

        int[] ans=new int[A.length];
        Stack<Integer> st=new Stack();
        st.push(0);
        for(int i=1;i<A.length;i++)
        {
            while(st.size()>0 && A[st.peek()]<A[i])
            {
                ans[st.peek()]=A[i];
                st.pop();
            }
            st.push(i);

        }
        while(st.size()>0)
        {
            ans[st.peek()]=-1;
            st.pop();
        }

        return ans;
    }


    public  static int[]  getNextGreaterElement2(int[] A)
    {
        //RightToLeft

        //      we will not push the element on the stack .
        //      we will push index of that element.
        //      Popping the element and setting the NGR will be done at the same time.
        //      The element which has popped is definetly greater element .
        //      All those elements which are not popped has no NGR.
        Stack<Integer > st=new Stack<>();
        int n=A.length;
        int[] ans=new int[n];
        st.push(A[n-1]);
        ans[n-1]=-1;
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && st.peek()<=A[i])
                st.pop();
            if(st.size()==0)
                ans[i]=-1;
            else
                ans[i]=st.peek();
            st.push(A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans=getNextGreaterElement(new int[]{1, 5, 2, 3, 5});
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");

        System.out.println("\n");

        ans=getNextGreaterElement2(new int[]{1, 5, 2, 3, 5});
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");
    }
}
