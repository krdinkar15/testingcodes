package com.learnJava.streams.introStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestIteration {
    public static void main(String[] args) {
        List<String> titles= Arrays.asList("java8","In","Action");
        Stream<String> s= titles.stream();
        s.forEach(System.out::println); // fine
//        s.forEach(System.out::println); // stream has already been operated upon or closed

    List<String> names= new ArrayList<>();
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

    }
}
