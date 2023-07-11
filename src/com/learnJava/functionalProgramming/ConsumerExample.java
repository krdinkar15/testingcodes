package com.learnJava.functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
class Student
{
    String name;
    List<String> activites;

    public Student(String name, List<String> activites) {
        this.name = name;
        this.activites = activites;
    }

    public static List<Student> getAllStudents()
    {
        return Arrays.asList(new Student("Kamal",Arrays.asList("a1","b1")),new Student("Raj",Arrays.asList("a2","b2")));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", activites=" + activites +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getActivites() {
        return activites;
    }

    public void setActivites(List<String> activites) {
        this.activites = activites;
    }
}
public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> c1 =(s)->
        {
            System.out.println(s.toUpperCase());
        };
        c1.accept("Java -8");


        Consumer<Student> c2=(student)->{
            System.out.println(student.toString());
        };
        List<Student> lst=Student.getAllStudents();
        lst.forEach(c2);


        Consumer<Student> c3=(student)-> System.out.println("Name "+student.getName());
        Consumer<Student> c4=(student)-> System.out.println("Activities "+student.getActivites());

        lst.forEach(c3.andThen(c4)); // consumer chaining

        System.out.println("-----------");
        lst.forEach((student -> {
            if(student.getName()=="Raj")
            {
                c3.andThen(c4).accept(student);
            }
        }));

    }
}
