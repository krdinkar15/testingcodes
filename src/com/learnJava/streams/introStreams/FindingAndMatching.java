package com.learnJava.streams.introStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindingAndMatching {

    // allMatch , anyMatch, noneMatch, findAny,findFirst

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

        if(menu.stream().anyMatch(Dish::isVegetarian))
        {
//            System.out.println("Vegetarian Menu is there");
        }

        boolean isHealthy=menu.stream().allMatch(d->d.getCalories()<1000);

        // noneMatch  in the opposite of allMatch
        boolean isHealthy2=menu.stream().noneMatch(d->d.getCalories()>=1000);

        // anyMatch, allMatch and noneMath make use of short-circuiting  [ && , || ]


        Optional<Dish> dish=menu.stream().filter(Dish::isVegetarian).findAny();
        if(dish.isPresent())
        {
            // print
        }

        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(System.out::println);












    }

}
