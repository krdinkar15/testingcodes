package com.learnJava.streams.methodReference;

import java.util.Arrays;
import java.util.List;

public class MethodRef {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("c", "C", "a", "A", "B", "b");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Lambda :" + str);


        List<String> str2 = Arrays.asList("c", "C", "a", "A", "B", "b");
        str2.sort(String::compareToIgnoreCase);
        System.out.println("Method referecne : " + str2);


    }
}
