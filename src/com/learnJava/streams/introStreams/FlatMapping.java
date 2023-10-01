package com.learnJava.streams.introStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapping {
    public static void main(String[] args) {


        List<String> words=new ArrayList<>(Arrays.asList("Kamal","Raj"));


        // List<String> uniqueCharacters=words.stream().map(w->w.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());
        // This solution doesn't work because you now end up with list of stream [ Stream<Stream<String>> ]


        List<String> uniqueCharacters=words.stream().map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());

        // Using  the flatmap method has the effect of mapping each array not with a stream but with
        // the contents of that stream

        // All the separate stream that were generated when using map(Arrays::Stream) get amalgamated [ flattened into single stream ]


        List<Integer> num1=Arrays.asList(1,2,3);
        List<Integer> num2=Arrays.asList(3,4);
        List<int[]> pairs=num1.stream().flatMap(i->num2.stream().map(j->new int[]{i,j})).collect(Collectors.toList());
        pairs.forEach(x-> System.out.println(x[0] + " "+x[1]));


        // filter only those pairs whose sum is divisible by 3

        List<int[] > pairsDivBy3=num1
                .stream().
                flatMap(
                        i->num2.stream()
                                .filter(j-> ((i+j)%3==0))
                                .map(j->new int[]{i,j})
                ).collect(Collectors.toList());
        System.out.println("div by 3" );
        pairsDivBy3.forEach(x->System.out.println(x[0]+" "+x[1]));


    }
}
