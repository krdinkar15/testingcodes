package com.learnJava.lamda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
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

    }
}
