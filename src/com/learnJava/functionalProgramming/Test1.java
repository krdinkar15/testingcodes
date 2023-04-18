package com.learnJava.functionalProgramming;

public class Test1 {

    public static void main(String[] args) {

        // Defining an anonymous method upto java 7
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in Runnable thread");
            }
        };
        r.run();
        System.out.println("Running in main thread");
    }

}
