package com.learnJava.functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test6 {
    public static void main(String[] args)
    {
        List<String> names= Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2");
        Predicate<String> p= (s) ->s.startsWith("G");
        for(String str:names)
        {
            if(p.test(str))
                System.out.println(str);
        }

    }
}
