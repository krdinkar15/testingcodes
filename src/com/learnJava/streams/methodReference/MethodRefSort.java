package com.learnJava.streams.methodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student
{
    String name;
    Integer age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class StudentComparator implements Comparator<Student>
{
    @Override
    public int compare(Student s1,Student s2) {
        return s1.getAge().compareTo(s2.getAge());
    }
}
public class MethodRefSort {

    public static void main(String[] args) {
        List<Student> s1=new ArrayList<>(Arrays.asList(new Student("k3",3),new Student("K2",2),new Student("k1",1)));
        s1.sort(new StudentComparator());  // Passing code
        System.out.println(s1);


        //---------------------------- M2: Anonymous Class
        List<Student> s2=new ArrayList<>(Arrays.asList(new Student("k3",3),new Student("K2",2),new Student("k1",1)));
        s2.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        System.out.println(s2);


        //---------------------------- M3: Lambda
        List<Student> s3=new ArrayList<>(Arrays.asList(new Student("k3",3),new Student("K2",2),new Student("k1",1)));
        s3.sort(( a,b)->a.getAge().compareTo(b.getAge()));
        System.out.println(s3);

        //
        List<Student> s4=new ArrayList<>(Arrays.asList(new Student("k3",3),new Student("K2",2),new Student("k1",1)));
        s4.sort(Comparator.comparing((a)->a.getAge()));
        System.out.println(s4);



        // ----------------------   M4 : Method Referencing
        List<Student> s5=new ArrayList<>(Arrays.asList(new Student("k3",3),new Student("K2",2),new Student("k1",1)));
        s5.sort(Comparator.comparing(Student::getAge));
        System.out.println(s5);

       // Method referencing reverse order
        List<Student> s6=new ArrayList<>(Arrays.asList(new Student("k3",3),new Student("K2",2),new Student("k1",1)));
        s6.sort(Comparator.comparing(Student::getAge).reversed());
        System.out.println("S6 :"+s6);


        // Chaining Comparator:
        List<Student> s7=new ArrayList<>(Arrays.asList(new Student("k3",3),new Student("k4",2),new Student("K2",2),new Student("k1",1)));
        s7.sort(Comparator.comparing(Student::getAge).reversed().thenComparing(Student::getName));
        System.out.println("S7 : "+s7);


    }
}
