package com.learnJava.streams.introStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    // sum of all calories in the menu
    // highest calories dish
    public static void main(String[] args) {
        List<Dish> menu= new ArrayList<>();
        menu.add(new Dish("d1",false,800,Dish.Type.MEAT));
        menu.add(new Dish("d2",false,700,Dish.Type.MEAT));
        menu.add(new Dish("d3",false,400,Dish.Type.MEAT));
        menu.add(new Dish("d4",true,530,Dish.Type.OTHER));
        menu.add(new Dish("d5",true,350,Dish.Type.OTHER));
        menu.add(new Dish("d6",true,120,Dish.Type.OTHER));
        menu.add(new Dish("d7",true,550,Dish.Type.OTHER));
        menu.add(new Dish("d8",false,300,Dish.Type.FISH));
        menu.add(new Dish("d9",false,450,Dish.Type.FISH));

        List<Integer> lst= Arrays.asList(2,3,4,5);
        int sum=lst.stream().reduce(0,(a,b)->a+b);
        int product=lst.stream().reduce(1,(a,b)->a*b);
        System.out.println(sum + " "+product);


        int sum2=lst.stream().reduce(0,Integer::sum);

        Optional<Integer> sum3=lst.stream().reduce(Integer::sum); // Optional because lst may contain zero elements
        sum3.ifPresent(System.out::println);


        Optional<Integer> minm=lst.stream().reduce(Integer::min);
        Optional<Integer> maxm=lst.stream().reduce(Integer::max);
        minm.ifPresent(System.out::println);
        maxm.ifPresent(System.out::println);

        Optional<Integer> minm2=lst.stream().reduce((a,b)->(a>b)?b:a);
        minm2.ifPresent(System.out::println);


        // Count no of dishes
        long cnt=menu.stream().count();
        System.out.println(cnt);
        int cnt2=menu.stream().map(d->1).reduce(0,Integer::sum);
        System.out.println(cnt2);

        // A chain of  map and reduce is commonly know as map-reduce pattern
        // It was made famous by google's use of it for web searching because it can easily be parallelized.

        // Methods like map and filter doesn't have internal state  [ stateless ]
        // (Assuming the user-supplied lambda or method reference  has no internal mutable state. )

        // Operations like reduce ,sum,max need to have internal state to accumulate the result.




    }

}
