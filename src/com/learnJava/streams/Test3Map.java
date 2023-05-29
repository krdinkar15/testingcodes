package com.learnJava.streams;

import java.util.HashSet;
import java.util.Set;

public class Test3Map {
    public static void main(String[] args) {
//        Map<Integer,String> mp=new HashMap<>();
//        mp.put(1,"Kamal");
//        mp.put(2,"Raj");
//        mp.put(3,"Dinkar");
//        int res=0;
//        for(Map.Entry<Integer,String> entry:mp.entrySet())
//        {
//            if("Raj".equals(entry.getValue()))
//                res=entry.getKey();
//        }
//        System.out.println("Before Java 8"+res);

        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();
        s1.retainAll(s2);
        Set<String > s=new HashSet<>();


    }
}
