package com.learnJava.functionalProgramming;

public class Test2 {
    public static void main(String[] args) {
        // Java 8
        // This has been converted to lambda expression rather than anonymous method
        Runnable r =() -> System.out.println("Running in Runnable Thread");
        r.run();
        System.out.println("Running in main thread");
    }
}
