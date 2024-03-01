package com.learnJava.streams.introStreams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args)  {

        // Streams from values
        Stream<String> stream2=Stream.of("Amit","Raj","Ak");
        stream2.map(String::toUpperCase).forEach(System.out::println);



        // Streams from Arrays

        Stream<String> emptyStream = Stream.empty(); // Empty Stream.

        int[] numbers={2,3,4,5,6};
        int sum2= Arrays.stream(numbers).sum();


        // Stream from files :

        // Java NIO  API   (non -blocking I/O) which is used for I/O operations such as
        // processing files has been updated to take advantage of Streams API.


        // Files.lines returns a stream of lines
        long uniqueWords;
        try(Stream<String> lines= Files.lines(Paths.get("src/com/learnJava/streams/introStreams/file.txt"), Charset.defaultCharset()))
        {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")).distinct())
                    .collect(Collectors.counting());
            System.out.println(uniqueWords);
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }

        // Two static methods to  generate a stream from a function
        // Stream.Iterate and Stream.generate


        Stream.iterate(0,n->n+2)
                .limit(5)
                .forEach(System.out::println);
        // We say the stream is unbounded

        //Generating Fibonacci
        System.out.println("Generating Fibonnaci");
        Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]})
                .limit(5)
                .forEach(t-> System.out.println(t[0]));


        System.out.println("-------------Generate --------------");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);



    }
}
