package com.learnJava.functionalProgramming;

public class Test4 {
    public static void main(String[] args)
    {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New Thread Created using anonymous inner class object");
            }
        }).start();

       new Thread(()-> {
           System.out.println("New thread using lambda expression");
       }).start();
    }
}
