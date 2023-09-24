package com.learnJava.streams.behaviourParameterisation;

import com.learnJava.streams.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        List<Apple> apples=new ArrayList<>();
        apples.add(new Apple("red",150,"large"));
        apples.add(new Apple("blue",100,"small"));
        apples.add(new Apple("red",200,"large"));
        apples.add(new Apple("red",50,"small"));
        apples.add(new Apple("green",180,"large"));
        apples.add(new Apple("green",100,"medium"));

        List<Apple> result=filterApples(apples,new AppleHeavyPredicate());
        System.out.println("Heavy Apples "+result);

        result=filterApples(apples,new AppleGreenPredicate());
        System.out.println("Green Apples "+result);


        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        System.out.println("Sorted by weight [ASC] "+apples);


        apples.sort((Apple a,Apple b)->b.getWeight()-a.getWeight());
        System.out.println("Sorted by weight [DSC] "  +apples);


        apples.sort(Comparator.comparingInt(Apple::getWeight));
        System.out.println("Sorted by weight [ASC] "+apples);
    }

    private static List<Apple> filterApples(List<Apple> apples, ApplePredicate p) {
        // parameterized the behaviour
        List<Apple> appleslist=new ArrayList<>();
        for(Apple apple:apples)
        {
            if(p.test(apple))
            {
                appleslist.add(apple);
            }
        }
        return appleslist;
    }
}
