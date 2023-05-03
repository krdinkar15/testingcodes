package com.learnJava.streams;

import java.util.*;
import java.util.stream.*;

public class Test1 {
    public static void main(String[] args) {
        List<String > alpha=Arrays.asList("a","b","c","d");
        List<String> upperalpha=new ArrayList<>();
        for(String s:alpha)
            upperalpha.add(s.toUpperCase());
        System.out.println(upperalpha);


        List<String> collect=alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> nums=Arrays.asList(1,2,3,4);
        List<Integer> squared=nums.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println(squared);

        
    }
}
