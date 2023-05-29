package com.learnJava.lamda;

public class Test {

    //    ------------------  Prior to java 8 -----------------------------
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnable");
            }
        };
        new Thread(runnable).start();






        //----------------------    >= java 8 ----------------------------
        Runnable runnableLambda=() ->{
            System.out.println("Inside lambda runnable 1");
        };
        new Thread(runnableLambda).start();



        // In single line there is no need of curly braces.
        Runnable runnablelambda2= () -> System.out.println("Inside lambda runnable 2");
        new Thread(runnablelambda2).start();

        new Thread(()-> System.out.println("Inside lambda runnable 3")).start();
    }





}
