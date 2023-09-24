package com.learnJava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        List<Apple> apples=new ArrayList<>();
        apples.add(new Apple("red",150,"large"));
        apples.add(new Apple("blue",100,"small"));
        apples.add(new Apple("red",200,"large"));
        apples.add(new Apple("red",50,"small"));
        apples.add(new Apple("green",180,"large"));
        apples.add(new Apple("green",100,"medium"));


        System.out.println("Sequential processing");
        List<Apple> heavyApples=apples.stream().filter((Apple a)->a.getWeight()>=150).collect(Collectors.toList());
        System.out.println(heavyApples);



        System.out.println("Parallel Processing");
        heavyApples=apples.parallelStream().filter((Apple a)->a.getWeight()>=150).collect(Collectors.toList());
        System.out.println(heavyApples);

    }

}
