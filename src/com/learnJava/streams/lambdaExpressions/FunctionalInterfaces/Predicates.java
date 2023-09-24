package com.learnJava.streams.lambdaExpressions.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Predicate<T>
{
    boolean test(T t);
}
public class Predicates {

    //The java.util.function.Predicate interface defines an abstract method named test that
    // accepts an object of generic type T and returns a boolean.
    public static void main(String[] args) {
        List<String> name=new ArrayList<>(Arrays.asList("Kamal", "Raj", "", "Amit","","kk"));
        Predicate<String> nonEmptyPredicates=(String s) ->!s.isEmpty();
        List<String > nonEmpty=filter(name,nonEmptyPredicates);
        System.out.println(nonEmpty);
    }
    public static <T> List<T> filter(List<T> list,Predicate<T> p)
    {
        List<T> results = new ArrayList<>();
        for(T s:list)
        {
            if(p.test(s))
            {
                results.add(s);
            }
        }
        return results;
    }


}
