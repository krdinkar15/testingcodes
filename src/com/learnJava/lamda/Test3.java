package com.learnJava.lamda;

import java.util.*;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {

        List<List<Integer>> listoflist= Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );

        List<Integer> flattenedList=listoflist
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList);



        List<Integer[]> listofArrays=Arrays.asList(
                new Integer[]{1,2,3},
                new Integer[]{4,5,6},
                new Integer[]{7,8,9}
        );
        List<Integer> flattedlist2=listofArrays
                .stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(flattedlist2);


        List<String> listOfStrings=Arrays.asList("Hello","World");
        List<Character> flattedchar=listOfStrings
                .stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(ch->(char)ch)
                .collect(Collectors.toList());
        System.out.println(flattedchar);


        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A", Arrays.asList(1, 2, 3));
        map.put("B", Arrays.asList(4, 5, 6));
        map.put("C", Arrays.asList(7, 8, 9));

        List<Integer> flattenedList3=map.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList3);

    }
}
