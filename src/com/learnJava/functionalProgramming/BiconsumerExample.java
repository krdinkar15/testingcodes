package com.learnJava.functionalProgramming;

import java.util.List;
import java.util.function.BiConsumer;

public class BiconsumerExample {
    public static void main(String[] args) {
        BiConsumer<String ,String> biconsumer=(a,b)->{
            System.out.println(a+ " "+b);
        };
        biconsumer.accept("java-11","java-17");


        BiConsumer<Integer,Integer> multiply=(a,b)->
        {
            System.out.println("Multiplication is " +a*b);
        };
        BiConsumer<Integer,Integer> division=(a,b)->
        {
            System.out.println("Division is "+ (a/b));
        };
       multiply.andThen(division).accept(50,2);
       nameAndActivities();
    }

    public static void nameAndActivities()
    {
        BiConsumer<String , List<String>> biConsumer=(name,activities)-> System.out.println(name +" "+activities);
        List<Student> studentList=Student.getAllStudents();
        studentList.forEach(student -> {
            biConsumer.accept(student.getName(),student.getActivites());
        });
    }
}
