package com.learnJava.streams.introStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
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
        List<Dish> veg=new ArrayList<>();
        for(Dish d :menu)
        {
            if(d.isVegetarian())
            {
                veg.add(d);
            }
        }

        List<Dish> veg2=menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

        List<Integer> numbers= Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream().filter(i->i%2==0).distinct().forEach(System.out::println);

        // Truncating a stream
        List<Dish> cal300=menu.stream().filter(d->d.getCalories()>=300).limit(3).collect(Collectors.toList());
        System.out.println(cal300);

        // skiping first two
        List<Dish> cal_300_skip2=menu.stream().filter(d->d.getCalories()>=300).skip(2).collect(Collectors.toList());
        System.out.println(cal_300_skip2);


    }
}
