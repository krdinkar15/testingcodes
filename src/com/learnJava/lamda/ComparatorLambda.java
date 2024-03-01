package com.learnJava.lamda;

import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String[] args) {
        //--------------  Prior to java 8 -----------------

        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result of comparator: "+comparator.compare(3,4)); //-1



        // ------------------  Using lambda ---------------------------------
        Comparator<Integer> comparator2=(Integer a,Integer b)->{
            return a.compareTo(b);
        };
        System.out.println("Using lambda  " +comparator2.compare(5,6));


        Comparator<Integer> comparator3=(a,b)->{
            return a.compareTo(b);
        };
        System.out.println("Using lambda  : "+comparator3.compare(3,5));





    }
}
