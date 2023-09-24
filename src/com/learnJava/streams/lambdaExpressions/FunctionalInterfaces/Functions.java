package com.learnJava.streams.lambdaExpressions.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Function<T,R>
{
    R apply(T t);
}
public class Functions {
    //The java.util.function.Function<T, R> interface defines an abstract method named apply
    // that takes an object of generic type T as input and returns an object of generic type R.

    // In the listing that follows we show how you can use it to create a method map to transform a
    // list of Strings into a list of Integers containing the length of each String.

    public static <T,R> List<R> map(List<T> list,Function<T,R> function)
    {
        List<R> result=new ArrayList<>();
        for(T s: list)
        {
            result.add(function.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> i=map(Arrays.asList("Kamal","Raj","Dinkar"),(String s)->s.length());
        System.out.println(i);
    }
}
