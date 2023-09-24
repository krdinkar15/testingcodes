package com.learnJava.streams.lambdaExpressions.FunctionalInterfaces;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Consumer<T>
{
    void accept(T t);
}
public class Consumers {

    //The java.util.function.Consumer<T> interface defines an abstract method named accept that takes an object of generic type T
    // and returns no result (void).
    //You might use this interface when you need to access an object of type T and
    // perform some operations on it. For example, you can use it to create a method forEach,
    // which takes a list of Integers and applies an operation on each element of that list.
    public static <T> void forEach(List<T> list,Consumer<T> consumer)
    {
        for(T i:list)
        {
            consumer.accept(i);
        }
    }

    public static void main(String[] args) {
        forEach(Arrays.asList(1,2,3,4,6),(Integer i)-> System.out.println(i));
    }



}
