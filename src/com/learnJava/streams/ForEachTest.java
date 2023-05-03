package com.learnJava.streams;
import java.util.*;
import java.util.stream.Collectors;

public class ForEachTest {
	public static void main(String[] args) {
		List<String> lst=new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
		for(String s:lst) {
			System.out.print(s);
		}
		lst.forEach(System.out::print);
		lst.add(null);
		System.out.println("\nAfter adding null");
		lst.forEach(System.out::print);

		System.out.println("\nFiltering null");
		lst.stream().filter(x -> x!=null).collect(Collectors.toList()).forEach(x -> System.out.print(x));


		System.out.println("\n-------------- Iterating Over Map   -----------------");
		Map<String,Integer> hm=new HashMap<>();
		hm.put("A",1);
		hm.put("B",2);
		hm.put("C",3);
		hm.put(null,6);
		for(Map.Entry<String,Integer> mp:hm.entrySet()) {
			System.out.println(mp.getKey() +" "+mp.getValue());
		}
		System.out.println("Using Lambda");
		hm.forEach((x,y) -> System.out.println(x+" "+y));

		System.out.println("----------");
		hm.forEach((x,y) ->{
			if(x!=null) {
				System.out.println(x+" "+y);
			}}
		);

	}
    
}
