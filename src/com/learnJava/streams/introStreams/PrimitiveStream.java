package com.learnJava.streams.introStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {
    // To avoid hidden boxing cost java 8 introduces three primitive specialized stream
    // IntStream , DoubleStream, LongStream.

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




        menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum).ifPresent(System.out::println);


        int sum=menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(sum);

        // Instead on Stream<Integer> we are getting InsStream

        // The operations of an IntStream are restricted to produce primitive integers

        IntStream intStream=menu.stream().mapToInt(Dish::getCalories); // converting a stream to a numeric stream
        Stream<Integer> stream=intStream.boxed(); // Converting the numeric stream to a Stream.



        OptionalInt maxCalories=menu.stream().mapToInt(Dish::getCalories).max();
        int maxm=maxCalories.orElse(1);
        System.out.println(maxm);


        IntStream.rangeClosed(1,100).filter(i->i%27==0).forEach(System.out::println);

        IntStream evenNumbers=IntStream.rangeClosed(1,100).filter(i->i%2==0); // Inclusive
        System.out.println(evenNumbers.count());

        IntStream evenNumbers2=IntStream.range(1,100).filter(i->i%2==0);  // Exclusive
        System.out.println(evenNumbers2.count());



    }

}
