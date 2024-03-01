package com.learnJava.lamda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestFilter {
    public static void main(String[] args) {
        List<String> strList= Arrays.asList("abc","abcd","ghi","mnop","p");
        long count=strList.stream().count();
        System.out.println(count);

        long count4length=strList.stream().filter(x->x.length()==4).count();
        System.out.println(count4length);


        long cnt=strList.stream().filter(x->x.length()>2).count();
        System.out.println(cnt);


        List<String> lst=strList.stream().filter(x->x.length()>2).collect(Collectors.toList());
        System.out.println(lst);


        String str=strList.stream().collect(Collectors.joining(","));
        System.out.println(str);


        List<Integer> numbers=Arrays.asList(2,4,6,3,2,6,4,2);
        List<Integer> distint=numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
        System.out.println(distint);
        IntSummaryStatistics stats=distint.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(stats);


        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        final long countFriendsWithN=friends.stream().filter(s -> s.startsWith("N")).count();
        System.out.println(countFriendsWithN);

        final Predicate<String> filterN=name ->name.startsWith("N");
        final long countFriendsWithN2=friends.stream().filter(filterN).count();
        System.out.println(countFriendsWithN2);


        System.out.println(friends.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));

        String name="Kamal";
        name.chars().forEach(System.out::println); // It will print the ASCII character.
        name.chars().forEach(TestFilter::printChar); // It prints Kamal

    }

    private static void printChar(int achar)
    {
        System.out.println((char) achar);
    }
}
