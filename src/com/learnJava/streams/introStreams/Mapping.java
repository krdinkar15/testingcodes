package com.learnJava.streams.introStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    //  A very common data processing idioms is to select information from certain objects.
    // In SQL you can select particular  column from a table  the stream  API provides similar
    /// facilities through Map and FlatMap methods.


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


        List<String> allDishes=menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(allDishes);

        List<Integer> dishesLength=menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(dishesLength);


        List<Integer> nums= Arrays.asList(1,2,3,4,5);
        List<Integer> squared=nums.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(squared);


    }
}
