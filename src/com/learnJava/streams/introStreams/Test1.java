package com.learnJava.streams.introStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Dish {

    enum Type { MEAT, FISH, OTHER }
    String name;
    boolean vegetarian;
    Integer calories;
    Type type;

    public Dish(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public Dish(String name, Boolean vegetarian, Integer calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", isvegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}

public class Test1 {
    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("d1", 110));
        dishes.add(new Dish("d2", 50));
        dishes.add(new Dish("d3", 70));
        dishes.add(new Dish("d4", 120));
        dishes.add(new Dish("d5", 20));

        List<String> lowcalorieDishes = dishes.stream()
                .filter(dish -> dish.getCalories() < 100)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(Collectors.toList());
        System.out.println("All low calories food "+lowcalorieDishes);

        List<String> lowcalorieDishesonlyTwo = dishes.stream()
                .filter(dish -> dish.getCalories() < 100)
                .sorted(Comparator.comparing(Dish::getCalories))
                .limit(2)
                .map(Dish::getName).collect(Collectors.toList());
        System.out.println("Only Two low calorie dishes "+lowcalorieDishesonlyTwo);

        List<String> highCaloriesdishes=dishes.parallelStream()
                .filter(dish -> dish.getCalories()>100)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(highCaloriesdishes);





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
