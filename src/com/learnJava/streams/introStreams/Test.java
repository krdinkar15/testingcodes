package com.learnJava.streams.introStreams;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,String > mp=new HashMap<>();
        mp.put("a1","b1");
        System.out.println(mp.get("a2"));
    }
}
