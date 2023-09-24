package com.learnJava.streams.lambdaExpressions.FunctionalInterfaces;

public class Test1 {
    public static void process(Runnable r)
    {
        r.run();
    }
    public static void main(String[] args) {
        process(()-> System.out.println("Hii Kamal"));

        //The lambda expression  [ ()-> sout("kamal")  ] takes no parameter and returns void
        // This is exactly the signature of the run method in the Runnable Interfaces.
    }
}
