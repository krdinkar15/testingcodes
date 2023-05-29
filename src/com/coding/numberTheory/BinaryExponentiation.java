package com.coding.numberTheory;

public class BinaryExponentiation {

    private static long binaryExp(int a, int b, int M) {
        //a^b%M
        a=a%M;
        long res=1;
        while (b>0)
        {
            if((b&1)==1)
                res=(res*a)%M;
            a=(a*a)%M;
            b=b>>1;
        }
        return res;

    }
}
